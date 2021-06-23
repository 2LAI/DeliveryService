package exposit.delivery.repository;

import exposit.delivery.model.entity.Position;
import exposit.delivery.model.entity.Product;
import exposit.delivery.model.entity.Score;


import java.util.ArrayList;
import java.util.List;

public class ScoreRepository {

    public static final List<Score> scoreList = new ArrayList<>();

    //just for Data Base
    public static void initializeScoreRepository() {

        System.out.println(ProductRepository.productList.get(1));

        List<Position> productList1 = new ArrayList<>();
        productList1.add(0, new Position(ProductRepository.productList.get(0), "Milk 3.2%", 14.4, 3));
        productList1.add(1, new Position(ProductRepository.productList.get(2), "Orange Juice", 18.4, 10));

        scoreList.add(new Score(1L, "Evroopt", "Minsk", "Kovalevskaya, 25", productList1));
        scoreList.add(new Score(2L, "Dionis", "Grodno", "Kabyaka, 15", productList1));
        scoreList.add(new Score(3L, "Green", "Grodno", "Kupaly, 9", productList1));
        scoreList.add(new Score(4L, "Kupalinka", "Grodno", "BLK, 12", productList1));
        scoreList.add(new Score(5L, "Almi", "Grodno", "Pushkina, 31", productList1));
    }

}
