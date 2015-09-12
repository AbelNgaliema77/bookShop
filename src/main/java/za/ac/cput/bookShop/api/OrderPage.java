package za.ac.cput.bookShop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.bookShop.Resource.OrderResource;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.Loan;
import za.ac.cput.bookShop.domain.User;
import za.ac.cput.bookShop.services.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abel on 2015-08-15.
 */
@RestController
@RequestMapping(value = "/order/**")
public class OrderPage {

    @Autowired
    OrderService service;


    @RequestMapping(value = "/{ID}/Book", method = RequestMethod.GET)
      public Book getBook(@PathVariable Long ID) {
        return service.getBook(ID);
    }
    @RequestMapping(value = "/{ID}/User", method = RequestMethod.GET)
    public User getUser(@PathVariable Long ID) {
        return service.getUser(ID);
    }
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public List<OrderResource> getOrders(){
        List<Loan> loans = service.getLoans();
        List<OrderResource> resources = new ArrayList<OrderResource>(loans.size());

        for (Loan loan : loans) {
            OrderResource resource = new OrderResource.Builder(loan.getUser())
                   .setBook(loan.getBook())
                   .ID(loan.getID())
                    .mode(loan.getMode())
                    .state(loan.getState())
                    .build();
            Link link = new
                    Link("http://localhost:8080/Orders/"+resource.getID().toString())
                    .withRel("Loan");
            resource.add(link);
            resources.add(resource);
        }
        return resources;
    }



}
