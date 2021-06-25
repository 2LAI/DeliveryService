package exposit.delivery.service.implementation;

import exposit.delivery.app.DemoDeliveryService;
import exposit.delivery.model.domain.ProductCategory;
import exposit.delivery.model.entity.Position;
import exposit.delivery.model.entity.Product;
import exposit.delivery.model.entity.Store;
import exposit.delivery.repository.ProductRepository;
import exposit.delivery.repository.StoreRepository;
import exposit.delivery.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exposit.delivery.model.domain.ProductCategory.*;
import static exposit.delivery.utils.BufferConsole.consoleStr;

public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public void createNewProduct() {
        logger.info(ProductRepository.productList);
        logger.info("Enter new name of product: ");
        String productName = consoleStr();
        logger.info(Arrays.stream(values()).collect(Collectors.toList()));
        logger.info("Set category of product: ");
        ProductCategory productCategory = valueOf(consoleStr());
        ProductRepository.productList.add(new Product(ProductRepository.getProductID() + 1, productName, productCategory));
        ProductRepository.setProductID(ProductRepository.getProductID() + 1);
    }

    @Override
    public void updateProduct() {
        logger.info(ProductRepository.productList);
        logger.info("Enter id of Product to change: ");
        Integer id = Integer.valueOf(consoleStr());
        logger.info("What are you want to change?\n 1 - Name of the product \n" +
                "2 - Category of the product \n 3 - Back in main menu ");

        int changeField = Integer.parseInt(consoleStr());

        switch (changeField) {

            case 1:
                changeProductName(id);
                break;
            case 2:
                changeCategoryProduct(id);
                break;
            case 3:
                DemoDeliveryService.showMenu();
                break;
        }
    }

    @Override
    public void removeProduct() {
        logger.info(ProductRepository.productList);
        logger.info("Enter id of Product to remove: ");
        int id = Integer.parseInt(consoleStr());
        Product productToRemove = ProductRepository.productList.get(id);
        ProductRepository.productList.remove(productToRemove);
        logger.info("Product with" + id + " has been successfully removed");
        logger.info(ProductRepository.productList);
    }

    @Override
    public void searchProductByCategory() {
        for (ProductCategory id : values()) {
            logger.info("To find all products with category " + id + " enter " + id.getCode());
        }
        logger.info("Enter code of Category: ");
        int id = Integer.parseInt(consoleStr());
        List<Position> collect = StoreRepository.storeList.stream()
                .map(Store::getPositionListAtStore)
                .flatMap(positions -> positions.stream()
                        .filter(position -> position.getProduct().getProductCategory().equals(getByCode(id))))
                .collect(Collectors.toList());

        logger.info(collect);
    }

    private void changeCategoryProduct(Integer id) {
        logger.info(Arrays.stream(values()).collect(Collectors.toList()));
        logger.info("Set category of product: ");
        ProductRepository.productList.get(id).setProductCategory(valueOf(consoleStr()));
    }

    private void changeProductName(Integer id) {
        logger.info(ProductRepository.productList.get(id).getProductName());
        logger.info("Set new name of the product: ");
        String newName = consoleStr();
        ProductRepository.productList.get(id).setProductName(newName);
    }
}
