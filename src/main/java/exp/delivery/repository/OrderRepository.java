package exp.delivery.repository;

import exp.delivery.model.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public static List<Order> orderList = new ArrayList<>();

    private static Integer orderCount = 0;

    public static void setOrderCount(Integer paymentInDB) {
        orderCount = paymentInDB;
    }

    public static Integer getOrderCount() {
        return orderCount;
    }


}
