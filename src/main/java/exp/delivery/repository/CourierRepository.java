package exp.delivery.repository;

import exp.delivery.model.entity.Courier;

import java.util.ArrayList;
import java.util.List;

public class CourierRepository {

    public static List<Courier> courierList = new ArrayList<>();

    public static void initializeCourierRepository() {
        courierList.add(new Courier(0, "Alexey", "Tihomorov", "CRM1247"));
        courierList.add(new Courier(1, "Serhey", "Potapov", "FRG8517"));
    }

}
