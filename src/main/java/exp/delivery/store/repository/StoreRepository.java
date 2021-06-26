package exp.delivery.store.repository;

import exp.delivery.product.repository.ProductRepository;
import exp.delivery.store.model.Position;
import exp.delivery.store.model.Store;


import java.util.ArrayList;
import java.util.List;

import static exp.delivery.store.model.Position.*;

public class StoreRepository {

    public static List<Store> storeList = new ArrayList<>();

    //just for Data Base
    public static void initializeStoreRepository() {

        List<Position> productList = new ArrayList<>();
        productList.add(0, new Position(counter, ProductRepository.productList.get(0), "Milk 3.2%", 14.4, 3));
        productList.add(1, new Position(counter, ProductRepository.productList.get(2), "Orange Juice", 18.4, 10));

        List<Position> productList1 = new ArrayList<>();
        productList1.add(0, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano", 10.6, 2));
        productList1.add(1, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano 2", 16.7, 5));
        productList1.add(2, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano 3", 26.7, 6));
        productList1.add(3, new Position(counter, ProductRepository.productList.get(0), "Pasta - Milk", 26.7, 6));
        productList1.add(4, new Position(counter, ProductRepository.productList.get(0), "Pasta - Milk", 27.7, 6));
        productList1.add(5, new Position(counter, ProductRepository.productList.get(0), "Pasta - Milk", 28.7, 6));
        productList1.add(6, new Position(counter, ProductRepository.productList.get(0), "Pasta - Milk", 29.7, 6));

        List<Position> productList2 = new ArrayList<>();
        productList2.add(0, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano", 11.5, 8));
        productList2.add(1, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano 2", 18.7, 3));

        List<Position> productList3 = new ArrayList<>();
        productList3.add(0, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano", 13.2, 21));
        productList3.add(1, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano 2", 17.7, 12));

        List<Position> productList4 = new ArrayList<>();
        productList4.add(0, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano", 13.7, 22));
        productList4.add(1, new Position(counter, ProductRepository.productList.get(3), "Pasta - Italyano 2", 12.7, 10));

        storeList.add(new Store(Store.counter, "Evroopt", "Minsk", "Kovalevskaya, 25", productList));
        storeList.add(new Store(Store.counter, "Dionis", "Grodno", "Kabyaka, 15", productList1));
        storeList.add(new Store(Store.counter, "Green", "Grodno", "Kupaly, 9", productList2));
        storeList.add(new Store(Store.counter, "Kupalinka", "Grodno", "BLK, 12", productList3));
        storeList.add(new Store(Store.counter, "Almi", "Grodno", "Pushkina, 31", productList4));
    }

}
