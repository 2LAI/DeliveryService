package exp.delivery.model.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum PaymentTypes {

    CASH(0, "For cash"),
    DEBIT_CARD(1, "By debit card"),
    CREDIT_CARD(2, "By credit card");

    private final Integer code;
    private final String description;

    PaymentTypes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentTypes getByCode(Integer code) {

        Stream<PaymentTypes> values = Arrays.stream(PaymentTypes.values());

        Predicate<PaymentTypes> predicate = x -> x.getCode() == code;

        Optional<PaymentTypes> result = values.filter(predicate).findFirst();

        return result.get();
    }
}


