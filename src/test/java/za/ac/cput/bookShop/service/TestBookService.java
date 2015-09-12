package za.ac.cput.bookShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.bookShop.App;
import za.ac.cput.bookShop.domain.Author;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.Publisher;
import za.ac.cput.bookShop.repository.BookRepository;
import za.ac.cput.bookShop.services.BookService;

import java.util.List;

/**
 * Created by Abel on 2015-08-13.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestBookService extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private BookRepository repository;
    @Autowired
    private BookService service;
    @Test
    public void testCreate() throws Exception {

        Book item = new Book.Builder("90-1-0-4063-4")
                .name("Database Pinciples : Fundamentals of Design, implementations, and Management")
                .price(784.20)
                .authors(new Author.Builder("Carlos")
                        .fName("Coronel")
                        .build())
                .publisher(new Publisher.Builder("Cengage Learning")
                        .placeOfPublication("2006")
                        .build()).build();
        repository.save(item);
        id = item.getId();
        Assert.assertNotNull(item.getPrice());

    }

    @Test(dependsOnMethods = "testCreate" )
    public void testBookCopies() throws Exception {
        List<Book> bk = service.getBooks();
        Assert.assertNotNull(bk);
      //  repository.deleteAll();
    }

}
