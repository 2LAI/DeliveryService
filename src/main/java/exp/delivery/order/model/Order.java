package exp.delivery.order.model;

import exp.delivery.courier.model.Courier;
import exp.delivery.customer.model.Customer;
import exp.delivery.payment.model.Payment;
import exp.delivery.store.model.Position;
import exp.delivery.store.model.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class Order {

    public static Long counter = 0L;

    private Long id;
    private Customer customer;
    private Store store;
    private Payment payment;
    private Collection<Position> productOrderList;
    private Courier courier;

    @Override
    public String toString() {
        return "\nOrder " +
                "id=" + id +
                "customer=" + customer + "\n" +
                "store=" + store.getName() + "\n" +
                "payment=" + payment + "\n" +
                "productOrderList=" + productOrderList + "\n" +
                "courier=" + courier + "\n";
    }

    public Order(Long id, Customer customer, Store store, Payment payment, Collection<Position> productOrderList, Courier courier) {
        this.id = id;
        this.customer = customer;
        this.store = store;
        this.payment = payment;
        this.productOrderList = productOrderList;
        this.courier = courier;
        counter++;//for auto incrementation
    }
}
