package exposit.delivery.repository;

import exposit.delivery.model.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public static List<Order> orderList = new ArrayList<>();

    private Integer orderCount = 0;

    public void setOrderCount(Integer paymentInDB) {
        this.orderCount = paymentInDB;
    }

    public Integer getOrderCount() {
        return orderCount;
    }


}
