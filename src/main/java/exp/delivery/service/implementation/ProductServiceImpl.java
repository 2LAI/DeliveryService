package exp.delivery.service.implementation;

import exp.delivery.model.entity.Position;
import exp.delivery.utils.BufferConsole;
import exp.delivery.model.domain.ProductCategory;
import exp.delivery.model.entity.Product;
import exp.delivery.model.entity.Store;
import exp.delivery.service.ProductService;
import exp.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static exp.delivery.app.DemoDeliveryService.*;
import static exp.delivery.model.domain.ProductCategory.*;
import static exp.delivery.repository.ProductRepository.*;
import static exp.delivery.repository.StoreRepository.*;

public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public void createNewProduct() {
        logger.info(productList);
        logger.info("Enter new name of product: ");
        String productName = BufferConsole.consoleStr();
        logger.info(Arrays.stream(values()).collect(Collectors.toList()));
        logger.info("Set category of product: ");
        ProductCategory productCategory = valueOf(BufferConsole.consoleStr());
        productList.add(new Product(getProductID() + 1, productName, productCategory));
        setProductID(getProductID() + 1);
        new SaveJsonFile().saveProductJson(productList);
    }

    @Override
    public void updateProduct() {
        logger.info(productList);
        logger.info("Enter id of Product to change: ");
        Integer id = Integer.valueOf(BufferConsole.consoleStr());
        logger.info("What are you want to change?\n 1 - Name of the product \n" +
                "2 - Category of the product \n 3 - Back in main menu ");

        int changeField = Integer.parseInt(BufferConsole.consoleStr());

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
        }
        new SaveJsonFile().saveProductJson(productList);
    }

    @Override
    public void removeProduct() {
        logger.info(productList);
        logger.info("Enter id of Product to remove: ");
        int id = Integer.parseInt(BufferConsole.consoleStr());
        Product productToRemove = productList.get(id);
        productList.remove(productToRemove);
        logger.info("Product with" + id + " has been successfully removed");
        logger.info(productList);
        new SaveJsonFile().saveProductJson(productList);
    }

    @Override
    public List<Position> searchProductByCategory() {
        int id = chooseCategory("To find all products with category ");
        return storeList.stream()
                .map(Store::getPositionListAtStore)
                .flatMap(positions -> positions.stream()
                        .filter(position -> position.getProduct().getProductCategory().equals(getByCode(id))))
                .collect(Collectors.toList());
    }

    @Override
    public void sortProductByPrice() {
        List<Position> sortedPositionsByPrice = searchProductByCategory();
        logger.info(sortedPositionsByPrice.stream().sorted(Comparator.comparing(Position::getPrice)).collect(Collectors.toList()));
    }

    private void changeCategoryProduct(Integer id) {
        logger.info(Arrays.stream(values()).collect(Collectors.toList()));
        logger.info("Set category of product: ");
        productList.get(id).setProductCategory(valueOf(BufferConsole.consoleStr()));
    }

    private void changeProductName(Integer id) {
        logger.info(productList.get(id).getProductName());
        logger.info("Set new name of the product: ");
        String newName = BufferConsole.consoleStr();
        productList.get(id).setProductName(newName);
    }

    private int chooseCategory(String s) {
        for (ProductCategory id : values()) {
            logger.info(s + id + " enter " + id.getCode());
        }
        logger.info("Enter code of Category: ");
        return Integer.parseInt(BufferConsole.consoleStr());
    }
}