package exposit.delivery.service;

import exposit.delivery.model.domain.ProductCategory;
import exposit.delivery.model.entity.Position;
import exposit.delivery.model.entity.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    void createNewProduct();

    void updateProduct();

    void removeProduct();

    List<Position> searchProductByCategory();

    void sortProductByPrice();
}
