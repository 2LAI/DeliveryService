package exp.delivery.product.service;

import exp.delivery.exceptions.IncorrectInputException;
import exp.delivery.store.model.Position;
import exp.delivery.product.model.ProductCategory;
import exp.delivery.product.model.Product;
import exp.delivery.store.model.Store;
import exp.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static exp.delivery.DemoDeliveryService.*;
import static exp.delivery.product.model.ProductCategory.*;
import static exp.delivery.product.repository.ProductRepository.*;
import static exp.delivery.store.repository.StoreRepository.*;
import static exp.delivery.utils.BufferConsole.*;

public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public void createNewProduct() {
        logger.info(productList);

        logger.info("Enter new name of product: ");
        var productName = readline();

        logger.info(Arrays.stream(values()).collect(Collectors.toList()));

        logger.info("Set category of product: ");
        ProductCategory productCategory = valueOf(readline());

        productList.add(new Product(Product.counter, productName, productCategory));

        new SaveJsonFile().saveProductJson(productList);
    }

    @Override
    public void updateProduct() {
        logger.info(productList);

        logger.info("Enter id of Product to change: ");
        var id = Integer.valueOf(readline());

        logger.info("What are you want to change?\n 1 - Name of the product \n" +
                "2 - Category of the product \n 3 - Back in main menu ");

        var changeField = Integer.parseInt(readline());

        switch (changeField) {

            case 1:
                changeProductName(id);
                break;
            case 2:
                changeCategoryProduct(id);
                break;
            case 3:
                showMenu();
                break;
            default:
                throw new IncorrectInputException("Incorrect choice");
        }
        new SaveJsonFile().saveProductJson(productList);
    }

    @Override
    public void removeProduct() {
        logger.info(productList);

        logger.info("Enter id of Product to remove: ");
        var id = Integer.parseInt(readline());

        Product productToRemove = productList.get(id);
        productList.remove(productToRemove);
        logger.info("Product with" + id + " has been successfully removed");
        logger.info(productList);
        new SaveJsonFile().saveProductJson(productList);
    }

    @Override
    public List<Position> searchProductByCategory() {
        var id = chooseCategory("To find all products with category ");
        return storeList.stream()
                .map(Store::getPositionListAtStore)
                .flatMap(positions -> positions.stream()
                        .filter(position -> position.getProduct().getProductCategory().equals(getByCode(id))))
                .collect(Collectors.toList());
    }

    @Override
    public void sortProductByPrice() {
        List<Position> sortedPositionsByPrice = searchProductByCategory();
        logger.info(sortedPositionsByPrice.stream()
                .sorted(Comparator.comparing(Position::getPrice))
                .collect(Collectors.toList()));
    }

    private void changeCategoryProduct(Integer id) {
        logger.info(Arrays.stream(values()).collect(Collectors.toList()));
        logger.info("Set category of product: ");
        productList.get(id).setProductCategory(valueOf(readline()));
    }

    private void changeProductName(Integer id) {
        logger.info(productList.get(id).getProductName());
        logger.info("Set new name of the product: ");
        String newName = readline();
        productList.get(id).setProductName(newName);
    }

    private int chooseCategory(String s) {
        for (ProductCategory id : values()) {
            logger.info(s + id + " enter " + id.getCode());
        }

        logger.info("Enter code of Category: ");
        return Integer.parseInt(readline());
    }
}
