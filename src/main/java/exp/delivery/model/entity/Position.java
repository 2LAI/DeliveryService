package exp.delivery.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Position {

    private Integer id;
    private Product product;
    private String description;
    private Double price;
    private Integer quantity;

    @Override
    public String toString() {
        return "\nPosition{ " + id + "\n" +
                "product=" + product +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
