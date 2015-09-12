package za.ac.cput.bookShop.factory;

import za.ac.cput.bookShop.domain.Customer;

import java.util.Map;


public class CustomerFactory {

    public static Customer createCustomer(Map<String,String> value){
        return new Customer.Builder(value.get("c_name")).c_surname(value.get("c_surname")).build();
    }
}
