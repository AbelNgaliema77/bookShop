package za.ac.cput.bookShop.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.repository.BookRepository;
import za.ac.cput.bookShop.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abel on 2015-08-12.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;
    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<Book>();
        Iterable<Book> books = bookRepository.findAll();
        for (Book b : books){
            bookList.add(b);
        }
        return bookList;
    }
}
