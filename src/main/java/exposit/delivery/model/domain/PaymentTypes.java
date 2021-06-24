package exposit.delivery.model.domain;

public enum PaymentTypes {

    CASH(0, "For cash"),
    DEBIT_CARD(1, "By debit card"),
    CREDIT_CARD(2, "By credit card");

    private final Integer code;
    private final String description;

    private PaymentTypes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}


