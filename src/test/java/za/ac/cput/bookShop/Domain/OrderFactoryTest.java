package za.ac.cput.bookShop.Domain;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.domain.*;
import za.ac.cput.bookShop.factory.BookFactory;
import za.ac.cput.bookShop.factory.OrderFactory;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.User;
import za.ac.cput.bookShop.domain.Publisher;
import za.ac.cput.bookShop.domain.Author;
import za.ac.cput.bookShop.domain.Customer;
import za.ac.cput.bookShop.domain.UserAddress;
import za.ac.cput.bookShop.domain.Loan;



import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abel on 2015-09-12.
 */
public class OrderFactoryTest extends TestCase {

    @Test
    public void testCreate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("isbn","123-432-2321");
        values.put("name", "book test");
        Book item = BookFactory.createBook(values, 12.00, new Publisher.Builder("Abel").
                placeOfPublication("Cape").build(), new Author.Builder("Ngaliema").fName("Yeah").build());

        User user1 = new User.Builder("Abelg").userAddress(new UserAddress.Builder(10).city("Cape Town").
                country("RSA").build()).customerName(new Customer.Builder("Abel").c_surname("Ngaliema").build())
                .userPassword("Shekinah").build();

        Loan o1 = OrderFactory.createOrderFac("Ship","1 week",item,user1);

        Assert.assertEquals("Ship",o1.getMode());
        Assert.assertEquals("1 week",o1.getState());
        Assert.assertEquals("123-432-2321",o1.getBook().getISBN());
        Assert.assertEquals("book test", o1.getBook().getName());
        Assert.assertEquals(12.00, o1.getBook().getPrice());
        Assert.assertNotNull(o1.getBook().getAuthor());
        Assert.assertNotNull(o1.getBook().getPublisher());
        Assert.assertEquals("Abelg", o1.getUser().getUsername());
        Assert.assertEquals("Shekinah", o1.getUser().getUserPassword());
        Assert.assertNotNull(o1.getUser().getU1());
        Assert.assertNotNull(o1.getUser().getC1());



    }
    @Test
    public void testUpdate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("isbn","123-432-2321");
        values.put("name", "book test");
        Book item = BookFactory.createBook(values, 12.00, new Publisher.Builder("Abel").
                placeOfPublication("Cape").build(), new Author.Builder("Ngaliema").fName("Yeah").build());

        User user1 = new User.Builder("Abelg").userAddress(new UserAddress.Builder(10).city("Cape Town").
                country("RSA").build()).customerName(new Customer.Builder("Abel").c_surname("Ngaliema").build())
                .userPassword("Shekinah").build();

        Loan o1 = OrderFactory.createOrderFac("Ship","1 week",item, user1);

        Loan o2 = new Loan.Builder(o1.getUser()).copy(o1).state("2 weeks").build();

        Assert.assertEquals("Ship",o2.getMode());
        Assert.assertEquals("2 weeks",o2.getState());
        Assert.assertEquals("123-432-2321",o2.getBook().getISBN());
        Assert.assertEquals("book test", o2.getBook().getName());
        Assert.assertEquals(12.00, o2.getBook().getPrice());
        Assert.assertNotNull(o2.getBook().getAuthor());
        Assert.assertNotNull(o2.getBook().getPublisher());
        Assert.assertEquals("Abelg", o2.getUser().getUsername());
        Assert.assertEquals("Shekinah", o2.getUser().getUserPassword());
        Assert.assertNotNull(o2.getUser().getU1());
        Assert.assertNotNull(o2.getUser().getC1());
    }
}
