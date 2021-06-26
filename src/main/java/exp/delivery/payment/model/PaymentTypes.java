package exp.delivery.payment.model;

import exp.delivery.utils.exceptions.IncorrectInputException;

import java.util.Arrays;
import java.util.Objects;

public enum PaymentTypes {

    CASH(0, "For cash"),
    DEBIT_CARD(1, "By debit card"),
    CREDIT_CARD(2, "By credit card");

    private final Integer code;

    PaymentTypes(Integer code, String description) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static PaymentTypes getByCode(Integer code) {
        return Arrays.stream(PaymentTypes.values())
                .filter(paymentTypes -> Objects.equals(code, paymentTypes.getCode()))
                .findFirst()
                .orElseThrow(() -> new IncorrectInputException("Incorrect choice by code" + code));
    }
}