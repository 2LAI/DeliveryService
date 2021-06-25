package exposit.delivery.service;

import exposit.delivery.model.entity.Position;

import java.util.List;

public interface ProductService {

    void createNewProduct();

    void updateProduct();

    void removeProduct();

    List<Position> searchProductByCategory();

    void sortProductByPrice();
}
