package exp.delivery.product.repository;

import exp.delivery.product.model.ProductCategory;
import exp.delivery.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public static List<Product> productList = new ArrayList<>();

    public static void initializeProductRepository() {

        List<ProductCategory> productCategories = new ArrayList<>();
        productCategories.add(0, ProductCategory.MILK);
        productCategories.add(1, ProductCategory.DAIRY);

        List<ProductCategory> productCategories1 = new ArrayList<>();
        productCategories1.add(0, ProductCategory.DRINKS);
        productCategories1.add(1, ProductCategory.JUICE);

        List<ProductCategory> productCategories2 = new ArrayList<>();
        productCategories2.add(0, ProductCategory.BAKERY);

        List<ProductCategory> productCategories3 = new ArrayList<>();
        productCategories3.add(0, ProductCategory.FRUIT_AND_VEGETABLES);
        productCategories3.add(1, ProductCategory.FRUIT);

        List<ProductCategory> productCategories4 = new ArrayList<>();
        productCategories4.add(0, ProductCategory.FRUIT_AND_VEGETABLES);
        productCategories4.add(1, ProductCategory.VEGETABLES);

        productList.add(new Product(Product.counter, "Milk", productCategories));
        productList.add(new Product(Product.counter, "Milk 2.2%", productCategories));
        productList.add(new Product(Product.counter, "Orange Juice", productCategories1));
        productList.add(new Product(Product.counter, "Pasta", productCategories2));
        productList.add(new Product(Product.counter, "Banana", productCategories3));
        productList.add(new Product(Product.counter, "Tomato", productCategories4));
    }
}