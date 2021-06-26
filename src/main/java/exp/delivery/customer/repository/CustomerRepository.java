package exp.delivery.customer.repository;

import exp.delivery.customer.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public static List<Customer> customerList = new ArrayList<>();

    public static void initializeCustomerRepository() {

        customerList.add(new Customer(Customer.counter, "Alexandr", "Tulai", "AlexandrTulai13@gmail.com",
                "+37529666666", "Grodno, BLK 15"));
        customerList.add(new Customer(Customer.counter, "Andrey", "Bibikov", "AndreyBibikov12@gmail.com",
                "+37529666666", "Minsk, Pobedy 12"));
    }
}