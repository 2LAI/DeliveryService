package exposit.delivery.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import exposit.delivery.repository.CustomerRepository;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class SaveJsonFile {
    ObjectMapper objectMapper = new ObjectMapper();
    public void saveJson(Collection collection) {
        try {
            objectMapper.writeValue( new File( "src/main/resources/updateCustomer.json" ), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
