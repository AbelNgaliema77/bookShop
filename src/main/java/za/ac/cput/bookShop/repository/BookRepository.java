package za.ac.cput.bookShop.repository;


import org.springframework.data.repository.CrudRepository;
import za.ac.cput.bookShop.domain.Book;

/**
 * Created by Abel on 2015-05-03.
 */
public interface BookRepository extends CrudRepository<Book,Long > {
}
