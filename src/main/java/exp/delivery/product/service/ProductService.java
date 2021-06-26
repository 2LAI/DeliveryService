package exp.delivery.product.service;

import exp.delivery.position.model.Position;

import java.util.List;

public interface ProductService {

    void createNewProduct();

    void updateProduct();

    void removeProduct();

    List<Position> searchProductByCategory();

    void sortProductByPrice();
}
