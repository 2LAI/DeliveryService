package exp.delivery.courier.repository;

import exp.delivery.courier.model.Courier;
import exp.delivery.customer.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CourierRepository {

    public static List<Courier> courierList = new ArrayList<>();

    public static void initializeCourierRepository() {
        courierList.add(new Courier(Customer.counter, "Alexey", "Tihomorov", "CRM1247"));
        courierList.add(new Courier(Customer.counter, "Serhey", "Potapov", "FRG8517"));
    }
}