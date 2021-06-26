package exp.delivery.product.model;

import exp.delivery.utils.exceptions.IncorrectInputException;

import java.util.Arrays;
import java.util.Objects;

public enum ProductCategory {

    DAIRY(0, "Milk products"),
    MILK(1, "Milk"),
    CHEESE(2, "Cheese and cheese products"),
    YOGURTS_DESSERTS(3, "Yogurts and desserts"),
    FRUIT_AND_VEGETABLES(4, "Fruits and vegetables"),
    FRUIT(5, "Fruits"),
    VEGETABLES(6, "Vegetables"),
    BAKERY(6,"Bakery products"),
    CAKES(7,"Cakes"),
    BREAD(8,"Bread"),
    DRINKS(8,"Drinks"),
    JUICE(9,"Juice"),
    WATER(10,"Water");

    private final Integer code;

    ProductCategory(Integer code, String description) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProductCategory getByCode(Integer code) {
        return Arrays.stream(ProductCategory.values())
                .filter(productCategory -> Objects.equals(code, productCategory.getCode()))
                .findFirst()
                .orElseThrow(() -> new IncorrectInputException("Incorrect choice by code" + code));
    }
}