package za.ac.cput.bookShop.Domain;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.domain.UserAddress;
import za.ac.cput.bookShop.factory.UserAddressFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abel on 2015-09-12.
 */
public class UserAddressFactoryTest extends TestCase {

    @Test
    public void testCreate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("city","Cape");
        values.put("country", "RSA");

        UserAddress ua = UserAddressFactory.createBook(values, 8000);

        Assert.assertEquals("Cape", ua.getCity());
        Assert.assertEquals("RSA", ua.getCountry());
        Assert.assertEquals(8000, ua.getPostal());
    }

    @Test
    public void testUpdate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("city","Cape");
        values.put("country", "RSA");

        UserAddress ua = UserAddressFactory.createBook(values, 8000);
        UserAddress ue = new UserAddress.Builder(ua.getPostal()).copy(ua).city("Lusaka").build();

        Assert.assertEquals("Lusaka", ue.getCity());
        Assert.assertEquals("RSA", ue.getCountry());
        Assert.assertEquals(8000, ua.getPostal());

    }
}
