package exposit.delivery.repository;

import exposit.delivery.model.entity.Position;
import exposit.delivery.model.entity.Store;


import java.util.ArrayList;
import java.util.List;

public class StoreRepository {

    public static List<Store> storeList = new ArrayList<>();
    public static Integer storeInDB = 5;
    public static Integer numberOfPositionInDB = 12;
    public static Integer numberOfProductList = 10;

    //just for Data Base
    public static void initializeStoreRepository() {

        List<Position> productList = new ArrayList<>();
        productList.add(0, new Position(0, ProductRepository.productList.get(0), "Milk 3.2%", 14.4, 3));
        productList.add(1, new Position(1, ProductRepository.productList.get(2), "Orange Juice", 18.4, 10));

        List<Position> productList1 = new ArrayList<>();
        productList1.add(0, new Position(2, ProductRepository.productList.get(3), "Pasta - Italyano", 10.6, 2));
        productList1.add(1, new Position(3, ProductRepository.productList.get(3), "Pasta - Italyano 2", 16.7, 5));
        productList1.add(2, new Position(4, ProductRepository.productList.get(3), "Pasta - Italyano 3", 26.7, 6));
        productList1.add(3, new Position(5, ProductRepository.productList.get(0), "Pasta - Milk", 26.7, 6));

        List<Position> productList2 = new ArrayList<>();
        productList2.add(0, new Position(6, ProductRepository.productList.get(3), "Pasta - Italyano", 11.5, 8));
        productList2.add(1, new Position(7, ProductRepository.productList.get(3), "Pasta - Italyano 2", 18.7, 3));

        List<Position> productList3 = new ArrayList<>();
        productList3.add(0, new Position(8, ProductRepository.productList.get(3), "Pasta - Italyano", 13.2, 21));
        productList3.add(1, new Position(9, ProductRepository.productList.get(3), "Pasta - Italyano 2", 17.7, 12));

        List<Position> productList4 = new ArrayList<>();
        productList4.add(0, new Position(10, ProductRepository.productList.get(3), "Pasta - Italyano", 13.7, 22));
        productList4.add(1, new Position(11, ProductRepository.productList.get(3), "Pasta - Italyano 2", 12.7, 10));

        storeList.add(new Store(0, "Evroopt", "Minsk", "Kovalevskaya, 25", productList));
        storeList.add(new Store(1, "Dionis", "Grodno", "Kabyaka, 15", productList1));
        storeList.add(new Store(2, "Green", "Grodno", "Kupaly, 9", productList2));
        storeList.add(new Store(3, "Kupalinka", "Grodno", "BLK, 12", productList3));
        storeList.add(new Store(4, "Almi", "Grodno", "Pushkina, 31", productList4));
    }

}
