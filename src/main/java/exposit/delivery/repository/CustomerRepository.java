package exposit.delivery.repository;

import exposit.delivery.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public static List<Customer> customerList = new ArrayList<>();

    public static void initializeCustomerRepository() {

        customerList.add(new Customer(0L, "Alexandr", "Tulai", "AlexandrTulai13@gmail.com",
                "+37529666666", "Grodno, BLK 15"));
        customerList.add(new Customer(1L, "Andrey", "Bibikov", "AndreyTulai13@gmail.com",
                "+37529666666", "Grodno, BLK 15"));

    }
}
