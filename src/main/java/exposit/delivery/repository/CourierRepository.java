package exposit.delivery.repository;

import exposit.delivery.model.entity.Courier;

import java.util.ArrayList;
import java.util.List;

public class CourierRepository {

    public static List<Courier> courierList = new ArrayList<>();

    public static void initializeCourierRepository(){
        courierList.add(new Courier(0L, "Alexey", "Tihomorov","CRM1247"));
        courierList.add(new Courier(1L, "Serhey", "Potapov","FRG8517"));
    }

}
