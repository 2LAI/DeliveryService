package exp.delivery.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courier {

    private Integer id;
    private String firstName;
    private String lastName;
    private String carNumber;

}
