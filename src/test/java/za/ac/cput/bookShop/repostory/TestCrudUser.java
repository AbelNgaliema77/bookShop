package za.ac.cput.bookShop.repostory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.App;
import za.ac.cput.bookShop.domain.*;
import za.ac.cput.bookShop.repository.BookRepository;
import za.ac.cput.bookShop.repository.UserRepository;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudUser extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    UserRepository rep;

   @Test
    public void testCreate() throws Exception {

        User user1 = new User.Builder("Abel69").userAddress(new UserAddress.Builder(8000).city("Cape Town").
                country("RSA").build()).customerName(new Customer.Builder("Abel").c_surname("Ngaliema").build())
                .userPassword("Shekinah").build();
        rep.save(user1);
        id = user1.getId();
        Assert.assertNotNull(user1.getUserPassword());
    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        User user1 = rep.findOne(id);
        Assert.assertEquals("Abel69", user1.getUsername());
    }
   @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        User user = rep.findOne(id);
        User newUser = new User.Builder(user.getUsername())
                .copy(user).userPassword("Glory")
                .build();
        rep.save(newUser);
        Assert.assertEquals("Glory", newUser.getUserPassword());
        Assert.assertEquals("Shekinah", user.getUserPassword());
    }
    @Test (dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        User user = rep.findOne(id);
        rep.delete(user);
        User a = rep.findOne(id);
        Assert.assertNull(a);
    }




}
