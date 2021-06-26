package exp.delivery.product.model;

import exp.delivery.utils.exceptions.IncorrectInputException;

import java.util.Arrays;
import java.util.Objects;

public enum ProductCategory {

    MILK(0, "Milk products"),
    MEAT(1, "Meat products"),
    FRUITS(2, "Fresh fruits"),
    VEGETABLES(3, "Fresh vegetables"),
    BAKERY(4, "Bakery products"),
    FROZEN_FOOD(5, "Frozen food"),
    DRINKS(6, "Drinks, juices and water");

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