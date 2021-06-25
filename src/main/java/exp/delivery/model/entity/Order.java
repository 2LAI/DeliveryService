package exp.delivery.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
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
}
