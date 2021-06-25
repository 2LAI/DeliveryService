package exposit.delivery.model.entity;

import exposit.delivery.model.domain.ProductCategory;
import exposit.delivery.model.domain.SubProductCategory;
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
