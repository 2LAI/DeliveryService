package exposit.delivery.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    private Long id;
    private String name;
    private String city;
    private String address;
    private Collection<Position> productListAtStore;

}
