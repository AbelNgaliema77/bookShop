package za.ac.cput.bookShop.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.bookShop.domain.User;

/**
 * Created by Abel on 2015-08-10.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
