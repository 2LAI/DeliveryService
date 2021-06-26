package exp.delivery.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

    public static Long counter = 0L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;

    public Customer(Long id, String firstName, String lastName, String email, String phoneNumber, String homeAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        counter++;
    }
}
