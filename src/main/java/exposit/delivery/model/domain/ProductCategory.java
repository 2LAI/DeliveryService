package exposit.delivery.model.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ProductCategory {

    MILK(0, "Milk products"),
    MEAT(1, "Meat products"),
    FRUITS(2, "Fresh fruits"),
    VEGETABLES(3, "Fresh vegetables"),
    BAKERY(4, "Bakery products"),
    FROZEN_FOOD(5, "Frozen food"),
    DRINKS(6, "Drinks, juices and water");

    private final Integer code;
    private final String description;

    ProductCategory(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    ProductCategory(int code, String description, SubProductCategory subProductCategory) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ProductCategory getByCode(Integer code) {

        Stream<ProductCategory> values = Arrays.stream(ProductCategory.values());

        Predicate<ProductCategory> predicate = x -> x.getCode() == code;

        Optional<ProductCategory> result = values.filter(predicate).findFirst();

        return result.get();
    }


}
