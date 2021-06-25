package exp.delivery.service.implementation;

import exp.delivery.model.entity.Position;
import exp.delivery.model.entity.Store;
import exp.delivery.repository.ProductRepository;
import exp.delivery.repository.StoreRepository;
import exp.delivery.service.StoreService;
import exp.delivery.utils.BufferConsole;
import exp.delivery.utils.SaveJsonFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static exp.delivery.app.DemoDeliveryService.*;

public class StoreServiceImpl implements StoreService {

    private static final Logger logger = LogManager.getLogger(StoreServiceImpl.class);

    @Override
    public void createNewStore() {

        logger.info("Enter name of Store: ");
        String name = BufferConsole.consoleStr();
        logger.info("Enter city of Store: ");
        String city = BufferConsole.consoleStr();
        logger.info("Enter address of Store: ");
        String Store = BufferConsole.consoleStr();

        List<Position> positionCollection = new ArrayList<>();
        exp.delivery.model.entity.Store newStore = new Store(StoreRepository.storeInDB, name, city, Store, positionCollection);
        StoreRepository.storeInDB++;

        StoreRepository.storeList.add(StoreRepository.storeList.size(), newStore);
        logger.info("Customer has been created successfully");
        new SaveJsonFile().saveStoreJson(StoreRepository.storeList);
    }

    @Override
    public void updateStore() {
        logger.info(StoreRepository.storeList);
        logger.info("Enter id of Store: ");
        Integer id = Integer.valueOf(BufferConsole.consoleStr());
        logger.info("What are you want to change?\n 1 - Name of Store \n 2 - City of Store \n 3 - Address of Store " +
                "\n 4 - Update position list\n 5 - Create new position at this store\n 6 - Back in main menu ");

        int changeField = Integer.parseInt(BufferConsole.consoleStr());

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
        new SaveJsonFile().saveStoreJson(StoreRepository.storeList);
    }

    @Override
    public void removeStore() {
        logger.info(StoreRepository.storeList);
        logger.info("Enter id of store for remove: ");
        int id = Integer.parseInt(BufferConsole.consoleStr());
        Store storeToRemove = StoreRepository.storeList.get(id);
        StoreRepository.storeList.remove(storeToRemove);
    }

    private void updatePositionList(Integer id) {
        logger.info(StoreRepository.storeList.get(id).getPositionListAtStore());
        logger.info("Enter position id at the store: ");
        int positionOnStore = Integer.parseInt(BufferConsole.consoleStr());
        logger.info(StoreRepository.storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionOnStore))
                .collect(Collectors.toList()));
        logger.info("What do you want to change at this position?\n 1 - Change description\n2 - Change price\n3- Change quantity");
        int changeField = Integer.parseInt(BufferConsole.consoleStr());
        switch (changeField) {
            case 1:
                changeDescription(id, positionOnStore);
                break;
            case 2:
                changePrice(id, positionOnStore);
                break;
            case 3:
                changeQuantity(id, positionOnStore);
                break;
        }
        new SaveJsonFile().saveStoreJson(StoreRepository.storeList);
    }

    private void changeQuantity(Integer id, Integer positionId) {
        logger.info("Enter new quantity: ");
        int newQuantity = Integer.parseInt(BufferConsole.consoleStr());
        StoreRepository.storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionId))
                .findFirst().ifPresent(position -> position.setQuantity(newQuantity));
    }

    private void changePrice(Integer id, Integer positionId) {
        logger.info("Enter new price: ");
        Double newPrice = Double.parseDouble(BufferConsole.consoleStr());
        StoreRepository.storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionId))
                .findFirst().ifPresent(position -> position.setPrice(newPrice));
    }

    private void changeDescription(Integer id, Integer positionId) {
        logger.info("Enter new description: ");
        String newDescription = BufferConsole.consoleStr();
        StoreRepository.storeList.get(id).getPositionListAtStore().stream()
                .filter(position -> position.getId().equals(positionId))
                .findFirst().ifPresent(position -> position.setDescription(newDescription));
    }

    private void addNewPosition(Integer id) {
        logger.info(ProductRepository.productList);
        logger.info("Enter id of product to add at a position: ");
        String idOfProduct = BufferConsole.consoleStr();
        logger.info("Enter description of product to add at a position: ");
        String descriptionOfProduct = BufferConsole.consoleStr();
        logger.info("Enter price of product to add at a position: ");
        String priceOfProduct = BufferConsole.consoleStr();
        logger.info("Enter quantity of product to add at a position: ");
        String quantityOfProduct = BufferConsole.consoleStr();
        StoreRepository.storeList.get(id).getPositionListAtStore()
                .add(new Position(StoreRepository.numberOfPositionInDB, ProductRepository.productList.get(Integer.parseInt(idOfProduct)), descriptionOfProduct,
                        Double.parseDouble(priceOfProduct), Integer.parseInt(quantityOfProduct)));
        StoreRepository.numberOfPositionInDB++;
        logger.info("Position has been successfully added");
        logger.info("Do you want to add a new position at this Store? 1 - yes, 0 - no");
        int decision = Integer.parseInt(BufferConsole.consoleStr());
        if (decision == 1) {
            addNewPosition(id);
        }
    }

    private void changeAddressOfStore(Integer id) {
        logger.info("Enter new address for Store: ");
        String newAddressForStore = BufferConsole.consoleStr();
        StoreRepository.storeList.get(id).setName(newAddressForStore);
    }

    private void changeCityOfStore(Integer id) {
        logger.info("Enter new City for Store: ");
        String newCityForStore = BufferConsole.consoleStr();
        StoreRepository.storeList.get(id).setName(newCityForStore);
    }

    private void changeStoreName(Integer id) {
        logger.info("Enter new Store name: ");
        String newStoreName = BufferConsole.consoleStr();
        StoreRepository.storeList.get(id).setName(newStoreName);
    }
}
