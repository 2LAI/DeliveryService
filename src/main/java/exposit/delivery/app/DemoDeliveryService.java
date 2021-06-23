package exposit.delivery.app;

import exposit.delivery.repository.StoreRepository;
import exposit.delivery.service.implementation.CustomerServiceImpl;
import exposit.delivery.service.implementation.StoreServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        showMenu();
    }

    public static void showMenu() {

        logger.info("\n1 - Create new customer\n" +
                "2 - Update customer information\n" +
                "3- Delete customer\n" +
                "4- Create new store\n" +
                "5- Update store\n" +
                "Enter number of operation:");
        String menuItem = consoleStr();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        StoreServiceImpl storeService = new StoreServiceImpl();


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
        }
        logger.info(StoreRepository.storeList);
        showMenu();

    }
}
