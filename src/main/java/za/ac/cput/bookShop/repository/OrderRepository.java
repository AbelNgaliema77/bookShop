package za.ac.cput.bookShop.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.bookShop.domain.Loan;

public interface OrderRepository  extends CrudRepository<Loan,Long> {
}
