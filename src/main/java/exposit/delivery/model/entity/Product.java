package exposit.delivery.model.entity;

import exposit.delivery.model.domain.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private Long id;
    private String productName;
    private ProductCategory productCategory;


}
