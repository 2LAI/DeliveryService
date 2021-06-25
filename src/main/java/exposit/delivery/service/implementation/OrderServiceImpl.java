package exposit.delivery.service.implementation;

import exposit.delivery.model.domain.PaymentTypes;
import exposit.delivery.model.entity.*;
import exposit.delivery.repository.CourierRepository;
import exposit.delivery.repository.CustomerRepository;
import exposit.delivery.repository.OrderRepository;
import exposit.delivery.repository.StoreRepository;
import exposit.delivery.service.OrderService;
import exposit.delivery.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static exposit.delivery.utils.BufferConsole.consoleStr;

public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public void createOrder() {
        OrderRepository orderRepository = new OrderRepository();
        double sumValue = 0.0;
        boolean addNewPosition = true;
        List<Position> productsListOrder = new ArrayList<>();

        logger.info(StoreRepository.storeList);
        logger.info("Enter id of store for order: ");
        int idOfStore = Integer.parseInt(consoleStr());

        while (addNewPosition) {
            logger.info(StoreRepository.storeList.get(idOfStore));
            logger.info("Enter id of position for order: ");
            int idOfPositionToOrder = Integer.parseInt(consoleStr());
            sumValue = addPositionToOrder(sumValue, productsListOrder, idOfStore, idOfPositionToOrder);
            logger.info("Do you want add a new position? 1 - yes, 0 - no");
            int decision = Integer.parseInt(consoleStr());
            if (decision == 0) {
                addNewPosition = false;
            }
        }
        for (PaymentTypes id : PaymentTypes.values()) {
            logger.info("To choose type of payment: " + id + " enter " + id.getCode());
        }
        logger.info("Enter id of payment types: ");
        int idOfPaymentType = Integer.parseInt(consoleStr());

        OrderRepository.orderList.add(new Order(orderRepository.getOrderCount(),
                //current user
                CustomerRepository.customerList.get(0),
                StoreRepository.storeList.get(idOfStore),
                new Payment(CustomerRepository.customerList.get(0),
                        DateUtils.asDate(LocalDate.now()), sumValue,
                        PaymentTypes.getByCode(idOfPaymentType)),
                productsListOrder,
                CourierRepository.courierList.get(0)));
        orderRepository.setOrderCount(orderRepository.getOrderCount() + 1);
    }

    private Double addPositionToOrder(Double sumValue, List<Position> productsListOrder, int idOfStore, int idOfPositionToOrder) {
        Position positionToOrder = addPos(idOfStore, idOfPositionToOrder);
        productsListOrder.add(positionToOrder);

        Double currentValue = getProductPrice(idOfStore, idOfPositionToOrder);
        sumValue += currentValue;
        return sumValue;
    }

    private static Double getProductPrice(int idOfStore, int idOfPositionToOrder) {
        return StoreRepository.storeList.get(idOfStore).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(idOfPositionToOrder))
                .findFirst().get().getPrice();
    }

    private static Position addPos(int idOfStore, int idOfPositionToOrder) {
        List<Position> currentPositionToOrder = StoreRepository.storeList.get(idOfStore).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(idOfPositionToOrder))
                .collect(Collectors.toList());
        return currentPositionToOrder.get(0);
    }

    @Override
    public void deleteOrder() {
        logger.info(OrderRepository.orderList);
        logger.info("Enter id of order to delete: ");
        int idOfOrder = Integer.parseInt(consoleStr());
        OrderRepository.orderList.remove(idOfOrder);
    }

    @Override
    public void showOrder() {
        logger.info(OrderRepository.orderList);
    }
}
