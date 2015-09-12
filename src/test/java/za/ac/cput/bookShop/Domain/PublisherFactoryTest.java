package za.ac.cput.bookShop.Domain;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.domain.Publisher;
import za.ac.cput.bookShop.factory.PublisherFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abel on 2015-09-12.
 */
public class PublisherFactoryTest extends TestCase {

    @Test
    public void testCreate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","VanSchalk");
        values.put("place", "Cape Town");
        Publisher item = PublisherFactory.createBook(values);

        Assert.assertEquals("Cape Town", item.getPlaceOfPublication());
        Assert.assertEquals("VanSchalk",item.getPublisherName());

    }
    @Test
    public void testUpdate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","VanSchalk");
        values.put("place", "Cape Town");
        Publisher item = PublisherFactory.createBook(values);

        Publisher newPublisher = new Publisher.Builder(item.getPublisherName()).copy(item).build();
        Assert.assertEquals("Cape Town", item.getPlaceOfPublication());
        Assert.assertEquals("VanSchalk",item.getPublisherName());

    }
}
