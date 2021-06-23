package exposit.delivery.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Position {

    private Product product;
    private String description;
    private Double price;
    private Integer quantity;
}
