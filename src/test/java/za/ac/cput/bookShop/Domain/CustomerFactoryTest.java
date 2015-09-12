package za.ac.cput.bookShop.Domain;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.domain.Customer;
import za.ac.cput.bookShop.factory.CustomerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abel on 2015-09-12.
 */
public class CustomerFactoryTest extends TestCase {

    @Test
    public void testCreate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("c_name","Othniel");
        values.put("c_surname", "Ngaliema");

        Customer c = CustomerFactory.createCustomer(values);

      Assert.assertEquals("Othniel", c.getC_name());
        Assert.assertEquals("Ngaliema", c.getC_surname());
    }
    @Test
    public void testUpdate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("c_name","Othniel");
        values.put("c_surname", "Ngaliema");

        Customer c = CustomerFactory.createCustomer(values);

        Customer newItem = new Customer.Builder(c.getC_name()).copy(c).c_surname("Ngal").build();

        Assert.assertNotNull("Othniel",newItem.getC_name());
        Assert.assertNotNull("Ngal", newItem.getC_surname());

    }
}
