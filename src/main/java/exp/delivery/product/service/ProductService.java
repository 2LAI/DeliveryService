package exp.delivery.product.service;

import exp.delivery.store.model.Position;

import java.util.List;

public interface ProductService {

    void createNewProduct();

    void updateProduct();

    void removeProduct();

    List<Position> searchProductByCategory();

    void sortProductByPrice();
}