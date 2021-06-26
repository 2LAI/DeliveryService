package exp.delivery.payment.model;

import exp.delivery.customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Payment {

    public static Integer counter = 0;

    private Long id;
    private Customer user;
    private Date date;
    private Double amount;
    private PaymentTypes paymentTypes;

    public Payment(Long id, Customer user, Date date, Double amount, PaymentTypes paymentTypes) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.amount = amount;
        this.paymentTypes = paymentTypes;
        counter++;
    }
}