package exp.delivery.service.implementation;

import exp.delivery.utils.BufferConsole;
import exp.delivery.model.entity.Customer;
import exp.delivery.service.CustomerService;
import exp.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static exp.delivery.repository.CustomerRepository.*;

public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    @Override
    public void createNewCustomer() {
        logger.info("Enter First name: ");
        String firstName = BufferConsole.consoleStr();
        logger.info("Enter Last name: ");
        String lastName = BufferConsole.consoleStr();
        logger.info("Enter email: ");
        String email = BufferConsole.consoleStr();
        logger.info("Enter phone number: ");
        String phoneNumber = BufferConsole.consoleStr();
        logger.info("Enter home address: ");
        String homeAddress = BufferConsole.consoleStr();

        Customer newCustomer = new Customer(customersInDB + 1, firstName, lastName, email, phoneNumber, homeAddress);
        customersInDB++;

        customerList.add(customerList.size(), newCustomer);
        logger.info("Customer has been created successfully");
        new SaveJsonFile().saveCustomerJson(customerList);
    }

    @Override
    public void updateCustomer() {
        logger.info(customerList);
        logger.info("Enter id of user: ");
        Integer id = Integer.valueOf(BufferConsole.consoleStr());
        logger.info("What are you want to change?\n 1 - First name \n 2 - Last Name \n 3 - Email \n 4 - Phone Number \n 5 - Home Address ");
        String changeField = BufferConsole.consoleStr();

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
        new SaveJsonFile().saveCustomerJson(customerList);
        logger.info("Customer has been successfully updated: ");
    }

    @Override
    public void removeCustomer() {
        logger.info(customerList);
        logger.info("Enter id of user to remove: ");
        var id = Integer.parseInt(BufferConsole.consoleStr());
        customerList.remove(id);
        logger.info("Customer has been removed successfully");
        new SaveJsonFile().saveCustomerJson(customerList);
        logger.info("Customer has been successfully removed: ");
    }


    private void changeFirstname(Integer id) {
        logger.info("Enter new First Name: ");
        String newFirstName = BufferConsole.consoleStr();
        customerList.get(id).setFirstName(newFirstName);
    }

    private void changeLastname(Integer id) {
        logger.info("Enter new Last Name: ");
        String newLastName = BufferConsole.consoleStr();
        customerList.get(id).setFirstName(newLastName);
    }

    private void changeEmail(Integer id) {
        logger.info("Enter new email Name: ");
        String newEmail = BufferConsole.consoleStr();
        customerList.get(id).setFirstName(newEmail);
    }

    private void changePhoneNumber(Integer id) {
        logger.info("Enter new phone number: ");
        String newPhoneNumber = BufferConsole.consoleStr();
        customerList.get(id).setFirstName(newPhoneNumber);
    }

    private void changeHomeAddress(Integer id) {
        logger.info("Enter new home address: ");
        String newHomeAddress = BufferConsole.consoleStr();
        customerList.get(id).setFirstName(newHomeAddress);
    }
}
