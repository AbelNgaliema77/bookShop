package za.ac.cput.bookShop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.bookShop.Resource.BookResource;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abel on 2015-08-15.
 */
@RestController
@RequestMapping(value = "/book/**")
public class BookPage {

    @Autowired
    BookService service;

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public List<BookResource> getBooks(){
        List<Book> books = service.getBooks();
        List<BookResource> resources = new ArrayList<BookResource>(books.size());

        for (Book book : books) {
            BookResource resource = new BookResource.Builder(book.getISBN())
                    .authors(book.getAuthor())
                    .publisher(book.getPublisher())
                    .id(book.getId())
                    .build();
            Link link = new
                    Link("http://localhost:8080/book/"+resource.getID().toString())
                    .withRel("Loan");
            resource.add(link);
            resources.add(resource);
        }
        return resources;
    }


}
