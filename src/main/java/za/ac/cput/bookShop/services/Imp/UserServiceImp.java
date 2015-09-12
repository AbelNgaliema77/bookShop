package za.ac.cput.bookShop.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.User;
import za.ac.cput.bookShop.repository.BookRepository;
import za.ac.cput.bookShop.repository.UserRepository;
import za.ac.cput.bookShop.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abel on 2015-08-12.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getUsers() {
        List<User> userList = new ArrayList<User>();
        Iterable<User> users =userRepository.findAll();
        for (User b : users){
            userList.add(b);
        }
        return userList;
    }
}
