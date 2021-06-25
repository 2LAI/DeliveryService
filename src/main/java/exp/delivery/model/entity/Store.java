package exp.delivery.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    private Integer id;
    private String name;
    private String city;
    private String address;
    private Collection<Position> positionListAtStore;

    @Override
    public String toString() {
        return "\nStore " +
                "id=" + id + "\n"+
                "Name='" + name + '\'' +"\n"+
                "City='" + city + '\'' +"\n"+
                "Address='" + address + '\'' +"\n"+
                "ProductListAtStore=" + positionListAtStore+ "\n";
    }
}
