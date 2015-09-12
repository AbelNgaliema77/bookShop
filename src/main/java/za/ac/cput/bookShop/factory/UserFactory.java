package za.ac.cput.bookShop.factory;

import za.ac.cput.bookShop.domain.Customer;
import za.ac.cput.bookShop.domain.User;
import za.ac.cput.bookShop.domain.UserAddress;

import java.util.Map;

/**
 * Created by Abel on 2015-08-10.
 */
public class UserFactory {

    public static User createUserFac(Map<String,String> values,Customer c,UserAddress ua)
    {
        User u1 = new User.Builder(values.get("name")).userPassword(values.get("password")).customerName(c).userAddress(ua).build();
        return u1;

    }
}