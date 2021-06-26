package exp.delivery.order.service.impl;

import exp.delivery.order.model.Order;
import exp.delivery.order.service.OrderService;
import exp.delivery.payment.model.Payment;
import exp.delivery.product.service.impl.ProductServiceImpl;
import exp.delivery.store.model.Position;
import exp.delivery.utils.DateUtils;
import exp.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exp.delivery.payment.model.PaymentTypes.*;
import static exp.delivery.courier.repository.CourierRepository.*;
import static exp.delivery.customer.repository.CustomerRepository.*;
import static exp.delivery.order.repository.OrderRepository.*;
import static exp.delivery.store.repository.StoreRepository.*;
import static exp.delivery.utils.BufferConsole.*;

public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public void createOrder() {

        var sumValue = 0.0;
        boolean addNewPosition = true;
        List<Position> productsListOrder = new ArrayList<>();

        logger.info(storeList);
        logger.info("Enter id of store for order: ");
        int storeId = Integer.parseInt(readline());

        while (addNewPosition) {
            logger.info(storeList.get(storeId));
            logger.info("Enter id of position for order: ");
            var idOfPositionToOrder = Long.parseLong(readline());
            sumValue = addPositionToOrder(sumValue, productsListOrder, storeId, idOfPositionToOrder);
            logger.info("Do you want add a new position? 1 - yes, 0 - no");
            int decision = Integer.parseInt(readline());
            if (decision == 0) {
                addNewPosition = false;
            }
        }

        //Showing all types of paying
        Arrays.stream(values())
                .forEach(it -> logger.info("To choose type of payment: " + it + " enter " + it.getCode()));

        logger.info("Enter id of payment types: ");
        var paymentTypesId = Integer.parseInt(readline());

        orderList.add(new Order(Order.counter,
                //current user, we have not identification
                customerList.get(0),
                storeList.get(storeId),
                new Payment(Payment.counter.longValue(),customerList.get(0),
                        DateUtils.asDate(LocalDateTime.now()), sumValue,
                        getByCode(paymentTypesId)),
                productsListOrder,
                courierList.get(0)));

        new SaveJsonFile().saveOrderJson(orderList);
    }

    private Double addPositionToOrder(Double sumValue, List<Position> productsListOrder, int storeId, Long positionId) {
        Position positionToOrder = addPosition(storeId, positionId);
        productsListOrder.add(positionToOrder);

        var currentValue = getProductPrice(storeId, positionId);
        sumValue = sumValue + currentValue;
        return sumValue;
    }

    private static Double getProductPrice(int storeId, Long idOfPositionToOrder) {
        return storeList.get(storeId).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(idOfPositionToOrder))
                .findFirst().orElseThrow().getPrice();
    }

    private static Position addPosition(int storeId, Long positionId) {
        List<Position> currentPositionToOrder = storeList.get(storeId).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionId))
                .collect(Collectors.toList());
        return currentPositionToOrder.get(0);
    }

    @Override
    public void deleteOrder() {
        logger.info(orderList);
        logger.info("Enter id of order to delete: ");
        var orderId = Integer.parseInt(readline());

        orderList.remove(orderId);
        new SaveJsonFile().saveOrderJson(orderList);
    }

    @Override
    public void showOrder() {
        logger.info(orderList);
    }
}