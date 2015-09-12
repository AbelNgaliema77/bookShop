package za.ac.cput.bookShop.factory;

import za.ac.cput.bookShop.domain.UserAddress;

import java.util.Map;

/**
 * Created by Abel on 2015-09-10.
 */
public class UserAddressFactory {

    public static UserAddress createBook(Map<String,String> value, int postal){
        return new UserAddress.Builder(postal).city(value.get("city")).country(value.get("country")).build();
    }
}
