package exposit.delivery.model.entity;

import exposit.delivery.model.domain.PaymentTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Integer id;
    private Customer user;
    private Date date;
    private BigDecimal amount;
    private PaymentTypes paymentTypes;


}
