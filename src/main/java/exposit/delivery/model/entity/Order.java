package exposit.delivery.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Customer customer;
    private Payment payment;
    private List<Product> orderItems;
}
