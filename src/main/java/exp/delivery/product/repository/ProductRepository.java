package exp.delivery.product.repository;

import exp.delivery.product.model.ProductCategory;
import exp.delivery.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static List<Product> productList = new ArrayList<>();

    public static void initializeProductRepository() {

        List<ProductCategory> productCategories = new ArrayList<>();
        productCategories.add(0,ProductCategory.MILK);
        productCategories.add(0,ProductCategory.MEAT);

        productList.add(new Product(Product.counter, "Milk_Meat", productCategories));
//        productList.add(new Product(Product.counter, "Milk 2.2%", ProductCategory.MILK));
//        productList.add(new Product(Product.counter, "Orange Juice", ProductCategory.MILK));
//        productList.add(new Product(Product.counter, "Pasta", ProductCategory.BAKERY));
//        productList.add(new Product(Product.counter, "Banana", ProductCategory.FRUITS));
//        productList.add(new Product(Product.counter, "Tomato", ProductCategory.VEGETABLES));
    }
}
