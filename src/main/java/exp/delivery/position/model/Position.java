package exp.delivery.position.model;

import exp.delivery.product.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Position {

    public static Long counter = 0L;

    private Long id;
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

    public Position(Long id, Product product, String description, Double price, Integer quantity) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        counter++;
    }
}
