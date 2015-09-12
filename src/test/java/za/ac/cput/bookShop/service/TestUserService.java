package za.ac.cput.bookShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.App;
import za.ac.cput.bookShop.domain.Customer;
import za.ac.cput.bookShop.domain.User;
import za.ac.cput.bookShop.domain.UserAddress;
import za.ac.cput.bookShop.repository.UserRepository;
import za.ac.cput.bookShop.services.OrderService;
import za.ac.cput.bookShop.services.UserService;

import java.util.List;

/**
 * Created by Abel on 2015-08-13.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestUserService extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;
    @Test
    public void testCreate() throws Exception {

        User user1 = new User.Builder("Abe").userAddress(new UserAddress.Builder(8000).city("Cape Town").
                country("RSA").build()).customerName(new Customer.Builder("Abel").c_surname("Ngaliema").build())
                .userPassword("Shekinah").build();
        repository.save(user1);
        id = user1.getId();
        Assert.assertNotNull(user1.getUserPassword());
    }

    @Test(dependsOnMethods = "testCreate" )
    public void testBookCopies() throws Exception {
       List<User>  user = service.getUsers();
        Assert.assertNotNull(user);
      //  repository.deleteAll();
    }
}
