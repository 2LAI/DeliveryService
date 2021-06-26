package exp.delivery.store.model;

import exp.delivery.position.model.Position;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class Store {

    public static Integer counter = 0;

    private Integer id;
    private String name;
    private String city;
    private String address;
    private Collection<Position> positionListAtStore;

    @Override
    public String toString() {
        return "\nStore " +
                "id=" + id + "\n" +
                "Name='" + name + '\'' + "\n" +
                "City='" + city + '\'' + "\n" +
                "Address='" + address + '\'' + "\n" +
                "ProductListAtStore=" + positionListAtStore + "\n";
    }

    public Store(Integer id, String name, String city, String address, Collection<Position> positionListAtStore) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.positionListAtStore = positionListAtStore;
        counter++;
    }
}
