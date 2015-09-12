package za.ac.cput.bookShop.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.Loan;
import za.ac.cput.bookShop.domain.User;
import za.ac.cput.bookShop.repository.OrderRepository;
import za.ac.cput.bookShop.services.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abel on 2015-08-12.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
//    @Autowired
//    UserRepository userRepository;
    public List<Loan> getLoans()
    {
        List<Loan> loanList = new ArrayList<Loan>();
        Iterable<Loan> loan=  orderRepository.findAll();
        for (Loan l : loan){
            loanList.add(l);
        }
        return loanList;
    }
    public User getUser(Long ID)
    {
        return orderRepository.findOne(ID).getUser();
    }
    public Book getBook(Long ID)
    {
        return orderRepository.findOne(ID).getBook();
    }
}
