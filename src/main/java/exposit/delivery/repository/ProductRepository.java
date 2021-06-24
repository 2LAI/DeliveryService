package exposit.delivery.repository;

import exposit.delivery.model.domain.ProductCategory;
import exposit.delivery.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static List<Product> productList = new ArrayList<>();

    public static void initializeProductRepository() {

        productList.add(new Product(0, "Milk 3.2%", ProductCategory.MILK));
        productList.add(new Product(1, "Milk 2.2%", ProductCategory.MILK));
        productList.add(new Product(2, "Orange Juice", ProductCategory.DRINKS));
        productList.add(new Product(3, "Pasta", ProductCategory.BAKERY));
        productList.add(new Product(4, "Banana", ProductCategory.FRUITS));
        productList.add(new Product(5, "Tomato", ProductCategory.VEGETABLES));

    }


}
