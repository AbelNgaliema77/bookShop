package za.ac.cput.bookShop.repostory;



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


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBook extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    BookRepository rep;

    @Test
    public void testCreate() throws Exception {

//        AmountOfBooks copies1 = new AmountOfBooks.Builder("05/12/2015").setState("Good").build();
//        AmountOfBooks copies2 = new AmountOfBooks.Builder("05/12/2015").setState("Great").build();
//        List<AmountOfBooks> copyList = new ArrayList<AmountOfBooks>();
//        copyList.add(copies1);
//        copyList.add(copies2);

        Book item = new Book.Builder("9-1-00-4863-4")
                .name("Database Principles : Fundamentals of Design, implementations, and Management")
                .price(784.20)
               .authors(new Author.Builder("Carlos")
                       .fName("Coronel")
                       .build())
                .publisher(new Publisher.Builder("Cengage Learning")
                        .placeOfPublication("2006")
                        .build()).build();
        rep.save(item);
        id = item.getId();
        Assert.assertNotNull(item.getPrice());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Book book = rep.findOne(id);
        Assert.assertEquals(784.2, book.getPrice());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Book book = rep.findOne(id);
        Book newbook = new Book.Builder(book.getISBN())
                .copy(book)
                .price(458.20)
                .build();
        rep.save(newbook);
        Assert.assertEquals(458.20, newbook.getPrice());
        Assert.assertEquals(784.2,book.getPrice());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Book book = rep.findOne(id);
        rep.delete(book);
        Book b = rep.findOne(id);
        Assert.assertNull(b);
    }
}
