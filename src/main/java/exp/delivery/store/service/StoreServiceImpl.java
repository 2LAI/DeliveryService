package exp.delivery.store.service;

import exp.delivery.store.model.Position;
import exp.delivery.store.model.Store;
import exp.delivery.product.repository.ProductRepository;
import exp.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static exp.delivery.DemoDeliveryService.*;
import static exp.delivery.store.repository.StoreRepository.*;
import static exp.delivery.utils.BufferConsole.*;

public class StoreServiceImpl implements StoreService {

    private static final Logger logger = LogManager.getLogger(StoreServiceImpl.class);

    @Override
    public void createNewStore() {

        logger.info("Enter name of Store: ");
        var name = readline();

        logger.info("Enter city of Store: ");
        var city = readline();

        logger.info("Enter address of Store: ");
        var store = readline();

        List<Position> positionCollection = new ArrayList<>();
        Store newStore = new Store(Store.counter, name, city, store, positionCollection);

        storeList.add(storeList.size(), newStore);
        logger.info("Customer has been created successfully");
        new SaveJsonFile().saveStoreJson(storeList);
    }

    @Override
    public void updateStore() {
        logger.info(storeList);
        logger.info("Enter id of Store: ");
        var id = Integer.valueOf(readline());

        logger.info("What are you want to change?\n 1 - Name of Store \n 2 - City of Store \n 3 - Address of Store " +
                "\n 4 - Update position list\n 5 - Create new position at this store\n 6 - Back in main menu ");

        var changeField = Integer.parseInt(readline());

        switch (changeField) {

            case 1:
                changeStoreName(id);
                break;
            case 2:
                changeCityOfStore(id);
                break;
            case 3:
                changeAddressOfStore(id);
                break;
            case 4:
                updatePositionList(id);
                break;
            case 5:
                addNewPosition(id);
                break;
            case 6:
                removeStore();
                break;
            case 7:
                showMenu();
                break;
        }
        new SaveJsonFile().saveStoreJson(storeList);
    }

    @Override
    public void removeStore() {
        logger.info(storeList);
        logger.info("Enter id of store for remove: ");
        int id = Integer.parseInt(readline());

        Store storeToRemove = storeList.get(id);
        storeList.remove(storeToRemove);
    }

    private void updatePositionList(Integer id) {
        logger.info(storeList.get(id).getPositionListAtStore());

        logger.info("Enter position id at the store: ");
        var positionAtStore = Long.parseLong(readline());

        logger.info(storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionAtStore))
                .collect(Collectors.toList()));

        logger.info("What do you want to change at this position?\n 1 - Change description\n2 - Change price\n3- Change quantity");
        var changeField = Integer.parseInt(readline());

        switch (changeField) {
            case 1:
                changeDescription(id, positionAtStore);
                break;
            case 2:
                changePrice(id, positionAtStore);
                break;
            case 3:
                changeQuantity(id, positionAtStore);
                break;
        }
        new SaveJsonFile().saveStoreJson(storeList);
    }

    private void changeQuantity(Integer id, Long positionId) {
        logger.info("Enter new quantity: ");
        var newQuantity = Integer.parseInt(readline());

        storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionId))
                .findFirst().ifPresent(position -> position.setQuantity(newQuantity));
    }

    private void changePrice(Integer id, Long positionId) {
        logger.info("Enter new price: ");
        var newPrice = Double.parseDouble(readline());

        storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionId))
                .findFirst().ifPresent(position -> position.setPrice(newPrice));
    }

    private void changeDescription(Integer id, Long positionId) {
        logger.info("Enter new description: ");
        var newDescription = readline();

        storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionId))
                .findFirst().ifPresent(position -> position.setDescription(newDescription));
    }

    private void addNewPosition(Integer id) {
        logger.info(ProductRepository.productList);
        logger.info("Enter id of product to add at a position: ");
        String productId = readline();

        logger.info("Enter description of product to add at a position: ");
        String productDescription = readline();

        logger.info("Enter price of product to add at a position: ");
        String productPrice = readline();

        logger.info("Enter quantity of product to add at a position: ");
        String productQuantity = readline();

        storeList.get(id).getPositionListAtStore()
                .add(new Position(Position.counter, ProductRepository.productList.get(Integer.parseInt(productId)), productDescription,
                        Double.parseDouble(productPrice), Integer.parseInt(productQuantity)));
        logger.info("Position has been successfully added");

        logger.info("Do you want to add a new position at this Store? 1 - yes, 0 - no");
        var decision = Integer.parseInt(readline());

        if (decision == 1) {
            addNewPosition(id);
        }
    }

    private void changeAddressOfStore(Integer id) {
        logger.info("Enter new address for Store: ");
        String newAddressForStore = readline();
        storeList.get(id).setName(newAddressForStore);
    }

    private void changeCityOfStore(Integer id) {
        logger.info("Enter new City for Store: ");
        String newCityForStore = readline();
        storeList.get(id).setName(newCityForStore);
    }

    private void changeStoreName(Integer id) {
        logger.info("Enter new Store name: ");
        String newStoreName = readline();
        storeList.get(id).setName(newStoreName);
    }
}