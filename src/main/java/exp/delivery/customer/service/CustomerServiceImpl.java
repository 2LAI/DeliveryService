package exp.delivery.customer.service;

import exp.delivery.customer.model.Customer;
import exp.delivery.exceptions.IncorrectInputException;
import exp.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static exp.delivery.customer.repository.CustomerRepository.*;
import static exp.delivery.utils.BufferConsole.*;
import static exp.delivery.utils.Constants.*;

public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    @Override
    public void createNewCustomer() {
        logger.info("Enter First name: ");
        var firstName = readline();

        logger.info("Enter Last name: ");
        var lastName = readline();

        logger.info("Enter email: ");
        var email = readline();

        logger.info("Enter phone number: ");
        var phoneNumber = readline();

        logger.info("Enter home address: ");
        var homeAddress = readline();

        var newCustomer = new Customer(Customer.counter, firstName, lastName, email, phoneNumber, homeAddress);

        customerList.add(customerList.size(), newCustomer);
        logger.info("Customer has been created successfully");

        new SaveJsonFile().saveCustomerJson(customerList);
    }

    @Override
    public void updateCustomer() {
        logger.info(customerList);
        logger.info("Enter id of user: ");
        var id = Integer.valueOf(readline());

        logger.info("What are you want to change?\n 1 - First name \n 2 - Last Name \n 3 - Email \n 4 - Phone Number \n 5 - Home Address ");
        var changeField = readline();

        switch (changeField) {

            case ONE:
                changeFirstname(id);
                break;
            case TWO:
                changeLastname(id);
                break;
            case THREE:
                changeEmail(id);
                break;
            case FOUR:
                changePhoneNumber(id);
                break;
            case FIVE:
                changeHomeAddress(id);
                break;
            default:
                throw new IncorrectInputException("Incorrect choice");
        }
        new SaveJsonFile().saveCustomerJson(customerList);
        logger.info("Customer has been successfully updated: ");
    }

    @Override
    public void removeCustomer() {
        logger.info(customerList);
        logger.info("Enter id of user to remove: ");
        var id = Integer.parseInt(readline());

        customerList.remove(id);

        logger.info("Customer has been removed successfully");
        new SaveJsonFile().saveCustomerJson(customerList);
    }

    private void changeFirstname(Integer id) {
        logger.info("Enter new First Name: ");
        var newFirstName = readline();
        customerList.get(id).setFirstName(newFirstName);
    }

    private void changeLastname(Integer id) {
        logger.info("Enter new Last Name: ");
        String newLastName = readline();
        customerList.get(id).setFirstName(newLastName);
    }

    private void changeEmail(Integer id) {
        logger.info("Enter new email Name: ");
        String newEmail = readline();
        customerList.get(id).setFirstName(newEmail);
    }

    private void changePhoneNumber(Integer id) {
        logger.info("Enter new phone number: ");
        String newPhoneNumber = readline();
        customerList.get(id).setFirstName(newPhoneNumber);
    }

    private void changeHomeAddress(Integer id) {
        logger.info("Enter new home address: ");
        String newHomeAddress = readline();
        customerList.get(id).setFirstName(newHomeAddress);
    }
}