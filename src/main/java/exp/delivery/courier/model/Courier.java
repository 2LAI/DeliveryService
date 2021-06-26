package exp.delivery.courier.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Courier {

    public static Long counter = 0L; //for auto incrementation

    private Long id;
    private String firstName;
    private String lastName;
    private String carNumber;

    //for a better showing at the console
    public Courier(Long id, String firstName, String lastName, String carNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.carNumber = carNumber;
        counter++; //for auto incrementation
    }
}
