package exp.delivery.product.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Product {

    public static Long counter = 0L;

    private Long id;
    private String productName;
    private ProductCategory productCategory;

    @Override
    public String toString() {
        return "\nProduct id = " + id + "\n" +
                "| productName = " + productName + "\n" +
                "| productCategory = " + productCategory + "\n";
    }

    public Product(Long id, String productName, ProductCategory productCategory) {
        this.id = id;
        this.productName = productName;
        this.productCategory = productCategory;
        counter++;
    }
}
