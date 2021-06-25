package exposit.delivery.app;

import exposit.delivery.model.domain.SwitchNumbers;
import exposit.delivery.service.implementation.CustomerServiceImpl;
import exposit.delivery.service.implementation.OrderServiceImpl;
import exposit.delivery.service.implementation.ProductServiceImpl;
import exposit.delivery.service.implementation.StoreServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static exposit.delivery.model.domain.SwitchNumbers.*;
import static exposit.delivery.repository.CourierRepository.initializeCourierRepository;
import static exposit.delivery.repository.CustomerRepository.initializeCustomerRepository;
import static exposit.delivery.repository.ProductRepository.initializeProductRepository;
import static exposit.delivery.repository.StoreRepository.initializeStoreRepository;
import static exposit.delivery.utils.BufferConsole.consoleStr;

public class DemoDeliveryService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    public static void main(String[] args) {

        initializeProductRepository();
        initializeStoreRepository();
        initializeCustomerRepository();
        initializeCourierRepository();

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
        String menuItem = consoleStr();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        StoreServiceImpl storeService = new StoreServiceImpl();
        ProductServiceImpl productService = new ProductServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        switch (menuItem) {
            case "1":
                customerService.createNewCustomer();
                break;
            case "2":
                customerService.updateCustomer();
                break;
            case "3":
                customerService.removeCustomer();
                break;
            case "4":
                storeService.createNewStore();
                break;
            case "5":
                storeService.updateStore();
                break;
            case "6":
                storeService.removeStore();
                break;
            case "7":
                productService.createNewProduct();
                break;
            case "8":
                productService.updateProduct();
                break;
            case "9":
                productService.removeProduct();
                break;
            case "10":
                logger.info(productService.searchProductByCategory());
                break;
            case "11":
                productService.sortProductByPrice();
                break;
            case "12":
                orderService.createOrder();
                break;
            case "13":
                orderService.showOrder();
                break;
            case "14":
                orderService.deleteOrder();
                break;
        }
        showMenu();

    }
}
