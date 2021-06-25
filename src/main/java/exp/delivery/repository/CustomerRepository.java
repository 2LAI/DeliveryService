package exp.delivery.repository;

import exp.delivery.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public static List<Customer> customerList = new ArrayList<>();
    public static Integer customersInDB = 0;

    public static void initializeCustomerRepository() {

        customerList.add(new Customer(0, "Alexandr", "Tulai", "AlexandrTulai13@gmail.com",
                "+37529666666", "Grodno, BLK 15"));
        customerList.add(new Customer(1, "Andrey", "Bibikov", "AndreyBibikov12@gmail.com",
                "+37529666666", "Minsk, Pobedy 12"));
        customersInDB++;
    }
}
