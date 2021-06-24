package exposit.delivery.model.entity;

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
    private Collection<Product> productOrderList;
    private Courier courier;
}
