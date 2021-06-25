package exposit.delivery.model.entity;

import exposit.delivery.model.domain.PaymentTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Customer user;
    private Date date;
    private Double amount;
    private PaymentTypes paymentTypes;


}
