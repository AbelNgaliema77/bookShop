package za.ac.cput.bookShop.Domain;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.domain.Author;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.Publisher;
import za.ac.cput.bookShop.factory.BookFactory;

import java.util.HashMap;
import java.util.Map;


public class BookFactoryTest extends TestCase {
    @Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("isbn","123-432-2321");
        values.put("name", "book test");
        Book item = BookFactory.createBook(values,12.00, new Publisher.Builder("Abel").
                placeOfPublication("Cape").build(), new Author.Builder("Ngaliema").fName("Yeah").build());

        Assert.assertNotNull(item.getPrice());
        Assert.assertEquals("book test", item.getName());
        Assert.assertEquals("123-432-2321", item.getISBN());
        Assert.assertEquals("Abel", item.getPublisher().getPublisherName());
        Assert.assertEquals("Cape",item.getPublisher().getPlaceOfPublication());
        Assert.assertEquals("Ngaliema",item.getAuthor().getLName());
        Assert.assertEquals("Yeah",item.getAuthor().getFName());



    }
    @Test
    public void testUpdate() throws Exception
    {

        Map<String,String> values = new HashMap<String,String>();
        values.put("isbn","123-432-2321");
        values.put("name", "book test");
        Book item = BookFactory.createBook(values, 12.00, new Publisher.Builder("Abel").
                placeOfPublication("Cape").build(), new Author.Builder("Ngaliema").fName("Yeah").build());

        Book newbook = new Book.Builder(item.getISBN())
                .copy(item)
                .price(458.20)
                .build();
       ;
        Assert.assertEquals(458.20,newbook.getPrice());
        Assert.assertEquals("book test", newbook.getName());
        Assert.assertEquals("123-432-2321", newbook.getISBN());
        Assert.assertEquals("Abel", newbook.getPublisher().getPublisherName());
        Assert.assertEquals("Cape", newbook.getPublisher().getPlaceOfPublication());
        Assert.assertEquals("Ngaliema", newbook.getAuthor().getLName());
        Assert.assertEquals("Yeah", newbook.getAuthor().getFName());

    }

}
