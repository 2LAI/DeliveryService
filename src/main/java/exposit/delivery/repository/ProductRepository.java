package exposit.delivery.repository;

import exposit.delivery.model.domain.ProductCategory;
import exposit.delivery.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static List<Product> productList = new ArrayList<>();

    public static void initializeProductRepository() {

        productList.add(new Product(0L, "Milk 3.2%", ProductCategory.MILK));
        productList.add(new Product(1L, "Milk 2.2%", ProductCategory.MILK));
        productList.add(new Product(2L, "Orange Juice", ProductCategory.DRINKS));
        productList.add(new Product(3L, "Pasta", ProductCategory.BAKERY));
        productList.add(new Product(4L, "Banana", ProductCategory.FRUITS));
        productList.add(new Product(5L, "Tomato", ProductCategory.VEGETABLES));

    }


}
