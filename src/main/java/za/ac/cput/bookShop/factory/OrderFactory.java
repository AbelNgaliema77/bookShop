package za.ac.cput.bookShop.factory;

import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.Loan;
import za.ac.cput.bookShop.domain.User;

/**
 * Created by Pst. Papy on 5/11/2015.
 */
public class OrderFactory {

 public static Loan createOrderFac(String mode,String state, Book books, User a)
    {
       Loan  o1 = new Loan.Builder(a).setBook(books).mode(mode).state(state).build();

      return o1;
    }
}
