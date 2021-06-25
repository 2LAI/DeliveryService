package exposit.delivery.service;

import exposit.delivery.model.domain.ProductCategory;
import exposit.delivery.model.entity.Product;

import java.util.Collection;

public interface ProductService {

    void createNewProduct();

    void updateProduct();

    void removeProduct();

    void searchProductByCategory();
}
