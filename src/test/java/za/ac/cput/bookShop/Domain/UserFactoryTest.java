package za.ac.cput.bookShop.Domain;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.domain.Customer;
import za.ac.cput.bookShop.domain.User;
import za.ac.cput.bookShop.domain.UserAddress;
import za.ac.cput.bookShop.factory.BookFactory;
import za.ac.cput.bookShop.factory.UserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abel on 2015-09-10.
 */
public class UserFactoryTest extends TestCase {

    @Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("name","Abel");
        values.put("password", "1234");
        User user = UserFactory.createUserFac(values, new Customer.Builder("Cust1").c_surname("custSurname").
                build(),new UserAddress.Builder(8000).city("Cape Town").country("RSA").build());


        Assert.assertEquals("Abel", user.getUsername());
        Assert.assertEquals("1234", user.getUserPassword());
        Assert.assertEquals("Cust1", user.getC1().getC_name());
        Assert.assertEquals("custSurname",user.getC1().getC_surname());
        Assert.assertEquals(8000,user.getU1().getPostal());
        Assert.assertEquals("Cape Town",user.getU1().getCity());
        Assert.assertEquals("RSA",user.getU1().getCountry());

    }
    @Test
    public void testUpdate() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();

        values.put("name","Abel");
        values.put("password", "1234");
        User user = UserFactory.createUserFac(values, new Customer.Builder("Cust1").c_surname("custSurname").
                build(), new UserAddress.Builder(8000).city("Cape Town").country("RSA").build());

        User newUser = new User.Builder(user.getUsername())
                .copy(user)
                .userPassword("12345")
                .build();
        Assert.assertEquals("Abel", newUser.getUsername());
        Assert.assertEquals("12345", newUser.getUserPassword());
        Assert.assertEquals("Cust1", newUser.getC1().getC_name());
        Assert.assertEquals("custSurname",newUser.getC1().getC_surname());
        Assert.assertEquals(8000, newUser.getU1().getPostal());
        Assert.assertEquals("Cape Town", newUser.getU1().getCity());
        Assert.assertEquals("RSA", newUser.getU1().getCountry());

    }
}
