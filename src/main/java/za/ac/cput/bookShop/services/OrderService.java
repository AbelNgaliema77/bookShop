package za.ac.cput.bookShop.services;

import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.Loan;
import za.ac.cput.bookShop.domain.User;

import java.util.List;

/**
 * Created by Abel on 2015-08-12.
 */
public interface OrderService {

    List<Loan> getLoans();
    User getUser(Long ID);
    Book getBook(Long ID);
}
