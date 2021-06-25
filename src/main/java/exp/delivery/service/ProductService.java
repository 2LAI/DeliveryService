package exp.delivery.service;

import exp.delivery.model.entity.Position;

import java.util.List;

public interface ProductService {

    void createNewProduct();

    void updateProduct();

    void removeProduct();

    List<Position> searchProductByCategory();

    void sortProductByPrice();
}
