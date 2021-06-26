package exp.delivery;

import exp.delivery.utils.exceptions.IncorrectInputException;
import exp.delivery.courier.repository.CourierRepository;
import exp.delivery.customer.repository.CustomerRepository;
import exp.delivery.product.repository.ProductRepository;
import exp.delivery.store.repository.StoreRepository;
import exp.delivery.customer.service.impl.CustomerServiceImpl;
import exp.delivery.order.service.impl.OrderServiceImpl;
import exp.delivery.product.service.impl.ProductServiceImpl;
import exp.delivery.store.service.impl.StoreServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static exp.delivery.utils.BufferConsole.*;
import static exp.delivery.utils.Constants.*;

public class DemoDeliveryService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    public static void main(String[] args) {
        initRepository();
        showMenu();
    }

    public static void showMenu() {

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        StoreServiceImpl storeService = new StoreServiceImpl();
        ProductServiceImpl productService = new ProductServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        logger.info("\n1 - Create new customer\n" +
                "2 - Update customer information\n" +
                "3 - Show all customers\n" +
                "4 - Delete customer\n" +
                "\n5 - Create new store\n" +
                "6 - Update store\n" +
                "7 - Show all stores\n" +
                "8 - Remove store\n" +
                "\n9 - Create new product\n" +
                "10 - Update product\n" +
                "11 - Show all products\n" +
                "12 - Remove product\n" +
                "13 - Find product by category\n" +
                "14 - Sort product by price\n" +
                "\n15 - Create order\n" +
                "16 - Show orders\n" +
                "17 - Delete order\n" +
                "Enter number of operation:");

        var menuItem = readline();

        switch (menuItem) {
            case ONE:
                customerService.createNewCustomer();
                break;
            case TWO:
                customerService.updateCustomer();
                break;
            case THREE:
                customerService.showCustomers();
                break;
            case FOUR:
                customerService.removeCustomer();
                break;
            case FIVE:
                storeService.createNewStore();
                break;
            case SIX:
                storeService.updateStore();
                break;
            case SEVEN:
                storeService.showStores();
                break;
            case EIGHT:
                storeService.removeStore();
                break;
            case NINE:
                productService.createNewProduct();
                break;
            case TEN:
                productService.updateProduct();
                break;
            case ELEVEN:
                productService.showProducts();
                break;
            case TWELVE:
                productService.removeProduct();
                break;
            case THIRTEEN:
                logger.info(productService.searchProductByCategory());
                break;
            case FOURTEEN:
                productService.sortProductByPrice();
                break;
            case FIFTEEN:
                orderService.createOrder();
                break;
            case SIXTEEN:
                orderService.showOrders();
                break;
            case SEVENTEEN:
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
