package exposit.delivery.service.implementation;

import exposit.delivery.model.entity.Customer;
import exposit.delivery.repository.CustomerRepository;
import exposit.delivery.service.CustomerService;
import exposit.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static exposit.delivery.utils.BufferConsole.consoleStr;

public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    @Override
    public void createNewCustomer() {
        logger.info("Enter First name: ");
        String firstName = consoleStr();
        logger.info("Enter Last name: ");
        String lastName = consoleStr();
        logger.info("Enter email: ");
        String email = consoleStr();
        logger.info("Enter phone number: ");
        String phoneNumber = consoleStr();
        logger.info("Enter home address: ");
        String homeAddress = consoleStr();

        Customer newCustomer = new Customer(CustomerRepository.customersInDB + 1, firstName, lastName, email, phoneNumber, homeAddress);
        CustomerRepository.customersInDB++;

        CustomerRepository.customerList.add(CustomerRepository.customerList.size(), newCustomer);
        logger.info("Customer has been created successfully");
        new SaveJsonFile().saveJson(CustomerRepository.customerList);
    }

    @Override
    public void updateCustomer() {
        logger.info("Enter id of user: ");
        Integer id = Integer.valueOf(consoleStr());
        logger.info("What are you want to change?\n 1 - First name \n 2 - Last Name \n 3 - Email \n 4 - Phone Number \n 5 - Home Address ");
        String changeField = consoleStr();

        switch (changeField) {

            case "1":
                changeFirstname(id);
                break;
            case "2":
                changeLastname(id);
                break;
            case "3":
                changeEmail(id);
                break;
            case "4":
                changePhoneNumber(id);
                break;
            case "5":
                changeHomeAddress(id);
                break;
        }
        new SaveJsonFile().saveJson(CustomerRepository.customerList);
    }

    @Override
    public void removeCustomer() {
        logger.info("Enter id of user to remove: ");
        var id = Integer.parseInt(consoleStr());
        CustomerRepository.customerList.remove(id);
        logger.info("Customer has been removed successfully");
        new SaveJsonFile().saveJson(CustomerRepository.customerList);
    }


    private void changeFirstname(Integer id) {
        logger.info("Enter new First Name: ");
        String newFirstName = consoleStr();
        CustomerRepository.customerList.get(id).setFirstName(newFirstName);
    }

    private void changeLastname(Integer id) {
        logger.info("Enter new Last Name: ");
        String newLastName = consoleStr();
        CustomerRepository.customerList.get(id).setFirstName(newLastName);
    }

    private void changeEmail(Integer id) {
        logger.info("Enter new email Name: ");
        String newEmail = consoleStr();
        CustomerRepository.customerList.get(id).setFirstName(newEmail);
    }

    private void changePhoneNumber(Integer id) {
        logger.info("Enter new phone number: ");
        String newPhoneNumber = consoleStr();
        CustomerRepository.customerList.get(id).setFirstName(newPhoneNumber);
    }

    private void changeHomeAddress(Integer id) {
        logger.info("Enter new home address: ");
        String newHomeAddress = consoleStr();
        CustomerRepository.customerList.get(id).setFirstName(newHomeAddress);
    }
}