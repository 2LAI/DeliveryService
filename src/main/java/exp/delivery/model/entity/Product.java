package exp.delivery.model.entity;

import exp.delivery.model.domain.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private Integer id;
    private String productName;
    private ProductCategory productCategory;

    @Override
    public String toString() {
        return "\nProduct id = " + id + "\n" +
                "| productName = " + productName + "\n" +
                "| productCategory = " + productCategory + "\n";
    }


}
