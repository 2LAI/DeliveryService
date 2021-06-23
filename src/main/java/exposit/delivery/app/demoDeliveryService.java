package exposit.delivery.app;

import exposit.delivery.repository.ProductRepository;
import exposit.delivery.repository.ScoreRepository;

import static exposit.delivery.repository.ProductRepository.initializeProductRepository;

public class demoDeliveryService {
    public static void main(String[] args) {

        initializeProductRepository();
        System.out.println(ProductRepository.productList);
        ScoreRepository.initializeScoreRepository();
        System.out.println(ScoreRepository.scoreList);

    }

}
