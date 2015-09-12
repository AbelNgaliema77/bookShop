package za.ac.cput.bookShop.Domain;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.domain.Author;
import za.ac.cput.bookShop.factory.AuthorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abel on 2015-09-12.
 */
public class AuthorFactoryTest extends TestCase {

    @Test
    public void testCreate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("lName","Learning");
        values.put("fName", "Cengage");
        Author author = AuthorFactory.createBook(values);

        Assert.assertEquals("Cengage", author.getFName());
        Assert.assertEquals("Learning", author.getLName());

    }
    @Test
    public void testUpdate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("lName","Learning");
        values.put("fName", "Cengage");
        Author author = AuthorFactory.createBook(values);

        Author newAuthor = new Author.Builder(author.getLName()).copy(author).fName("Changed").build();

        Assert.assertEquals("Changed", newAuthor.getFName());
        Assert.assertEquals("Learning", newAuthor.getLName());

    }

}
