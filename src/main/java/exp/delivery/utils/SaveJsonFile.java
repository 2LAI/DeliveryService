package exp.delivery.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import exp.delivery.customer.model.Customer;
import exp.delivery.order.model.Order;
import exp.delivery.product.model.Product;
import exp.delivery.store.model.Store;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import static exp.delivery.utils.Constants.*;

public class SaveJsonFile {

    ObjectMapper objectMapper = new ObjectMapper();

    public void saveCustomerJson(Collection<Customer> collection) {
        try {
            objectMapper.writeValue(new File(PATHNAME_UPDATE_CUSTOMER), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveProductJson(Collection<Product> collection) {
        try {
            objectMapper.writeValue(new File(PATHNAME_UPDATE_PRODUCT), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveStoreJson(Collection<Store> collection) {
        try {
            objectMapper.writeValue(new File(PATHNAME_UPDATE_STORE), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveOrderJson(Collection<Order> collection) {
        try {
            objectMapper.writeValue(new File(PATHNAME_UPDATE_ORDER), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}