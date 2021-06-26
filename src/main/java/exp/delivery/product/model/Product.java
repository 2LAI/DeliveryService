package exp.delivery.product.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor

public class Product {

    public static Long counter = 0L;

    private Long id;
    private String productName;
    private Collection <ProductCategory> productCategories;

    @Override
    public String toString() {
        return "\nProduct id = " + id + "\n" +
                "| productName = " + productName + "\n" +
                "| productCategory = " + productCategories + "\n";
    }

    public Product(Long id, String productName, Collection <ProductCategory> productCategories) {
        this.id = id;
        this.productName = productName;
        this.productCategories = productCategories;
        counter++;
    }
}