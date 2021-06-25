package exposit.delivery.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class SaveJsonFile {

    ObjectMapper objectMapper = new ObjectMapper();

    public void saveCustomerJson(Collection collection) {
        try {
            objectMapper.writeValue(new File("src/main/resources/updateCustomer.json"), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveProductJson(Collection collection) {
        try {
            objectMapper.writeValue(new File("src/main/resources/updateProduct.json"), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveStoreJson(Collection collection) {
        try {
            objectMapper.writeValue(new File("src/main/resources/updateStore.json"), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveOrderJson(Collection collection) {
        try {
            objectMapper.writeValue(new File("src/main/resources/updateOrder.json"), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
