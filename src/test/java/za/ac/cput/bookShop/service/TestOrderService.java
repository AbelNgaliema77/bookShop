package za.ac.cput.bookShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.App;
import za.ac.cput.bookShop.domain.*;
import za.ac.cput.bookShop.repository.OrderRepository;
import za.ac.cput.bookShop.services.OrderService;

/**
 * Created by Abel on 2015-08-12.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestOrderService extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private OrderRepository repository;
    @Autowired
    private OrderService service;
    @Test
    public void testCreate() throws Exception {

        Book item = new Book.Builder("61-7-010-403-8")
                .name("Database Principles : Fundamentals of Design")
                .price(784.20)
                .authors(new Author.Builder("Cabz")
                        .fName("FirstDay")
                        .build())
                .publisher(new Publisher.Builder("John Mil")
                        .placeOfPublication("2007")
                        .build())

                .build();

        User user1 = new User.Builder("Kevin7").userAddress(new UserAddress.Builder(10).city("Cape Town").
                country("RSA").build()).customerName(new Customer.Builder("Abel").c_surname("Ngaliema").build())
                .userPassword("Shekinah").build();

        Loan deal = new Loan.Builder(user1).mode("Ship").state("On the way").setBook(item).build();

        System.out.println(user1.getUsername() + " "+user1.getUserPassword());
        System.out.println(item.getName() + " "+item.getISBN());
        repository.save(deal);
        id = deal.getID();
        Assert.assertNotNull(id);

    }

    @Test(dependsOnMethods = "testCreate" )
    public void testBookCopies() throws Exception {
        User user = service.getUser(id);
        Assert.assertEquals(user.getUsername(),"Kevin7");
        System.out.print(user);
    //  repository.deleteAll();
    }




}
