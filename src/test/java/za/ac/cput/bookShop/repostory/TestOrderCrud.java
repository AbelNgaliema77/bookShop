package za.ac.cput.bookShop.repostory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.App;
import za.ac.cput.bookShop.domain.*;
import za.ac.cput.bookShop.repository.OrderRepository;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestOrderCrud extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    OrderRepository rep;


    @Test
    public void testCreate() throws Exception {

        Book item = new Book.Builder("637-4000-4803-8")
                .name("Database Principles : Fundamentals of Design")
                .price(784.20)
                .authors(new Author.Builder("Cabz")
                        .fName("FirstDay")
                        .build())
                .publisher(new Publisher.Builder("John Mil")
                        .placeOfPublication("2007")
                        .build())

                .build();

        User user1 = new User.Builder("Abelg").userAddress(new UserAddress.Builder(10).city("Cape Town").
                country("RSA").build()).customerName(new Customer.Builder("Abel").c_surname("Ngaliema").build())
                .userPassword("Shekinah").build();

        Loan deal = new Loan.Builder(user1).mode("Ship").state("On the way").setBook(item).build();

        System.out.println(user1.getUsername() + " "+user1.getUserPassword());
        System.out.println(item.getName() + " "+item.getISBN());
        rep.save(deal);
        id = deal.getID();
        Assert.assertNotNull(id);

    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Loan loan = rep.findOne(id);
        rep.findOne(id);
        org.junit.Assert.assertEquals("Ship", loan.getMode());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        User user1 = new User.Builder("Abel3").userAddress(new UserAddress.Builder(10).city("Cape Town").
                country("RSA").build()).customerName(new Customer.Builder("Abel").c_surname("Ngaliema").build())
                .userPassword("Shekinah").build();

        Loan loan = rep.findOne(id);
        Loan newLoan = new Loan.Builder(user1)
                .copy(loan)
                .mode("Road")
                .build();
        org.junit.Assert.assertEquals("Road", newLoan.getMode());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Loan loan = rep.findOne(id);
        rep.delete(loan);
        Loan l = rep.findOne(id);
        org.junit.Assert.assertNull(l);
    }



}
