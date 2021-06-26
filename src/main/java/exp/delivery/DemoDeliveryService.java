package exp.delivery;

import exp.delivery.exceptions.IncorrectInputException;
import exp.delivery.courier.repository.CourierRepository;
import exp.delivery.customer.repository.CustomerRepository;
import exp.delivery.product.repository.ProductRepository;
import exp.delivery.store.repository.StoreRepository;
import exp.delivery.customer.service.CustomerServiceImpl;
import exp.delivery.order.service.OrderServiceImpl;
import exp.delivery.product.service.ProductServiceImpl;
import exp.delivery.store.service.StoreServiceImpl;
import exp.delivery.utils.BufferConsole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static exp.delivery.utils.Constants.*;

public class DemoDeliveryService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    public static void main(String[] args) {
        initRepository();
        showMenu();
    }

    public static void showMenu() {

        logger.info("\n1 - Create new customer\n" +
                "2 - Update customer information\n" +
                "3 - Delete customer\n" +
                "4 - Create new store\n" +
                "5 - Update store\n" +
                "6 - Remove store\n" +
                "7 - Create new product\n" +
                "8 - Update product\n" +
                "9 - Remove product\n" +
                "10 - Find product by category\n" +
                "11 - Sort product by price\n" +
                "12 - Create order\n" +
                "13 - Show orders\n" +
                "14 - Delete order\n" +
                "Enter number of operation:");

        String menuItem = BufferConsole.readline();

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        StoreServiceImpl storeService = new StoreServiceImpl();
        ProductServiceImpl productService = new ProductServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        switch (menuItem) {
            case ONE:
                customerService.createNewCustomer();
                break;
            case TWO:
                customerService.updateCustomer();
                break;
            case THREE:
                customerService.removeCustomer();
                break;
            case FOUR:
                storeService.createNewStore();
                break;
            case FIVE:
                storeService.updateStore();
                break;
            case SIX:
                storeService.removeStore();
                break;
            case SEVEN:
                productService.createNewProduct();
                break;
            case EIGHT:
                productService.updateProduct();
                break;
            case NINE:
                productService.removeProduct();
                break;
            case TEN:
                logger.info(productService.searchProductByCategory());
                break;
            case ELEVEN:
                productService.sortProductByPrice();
                break;
            case TWELVE:
                orderService.createOrder();
                break;
            case THIRTEEN:
                orderService.showOrder();
                break;
            case FOURTEEN:
                orderService.deleteOrder();
                break;
            default:
                throw new IncorrectInputException("Incorrect choice");
        }
        showMenu();
    }

    private static void initRepository() {
        ProductRepository.initializeProductRepository();
        StoreRepository.initializeStoreRepository();
        CustomerRepository.initializeCustomerRepository();
        CourierRepository.initializeCourierRepository();
    }


}
