package za.ac.cput.bookShop.Resource;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.User;

/**
 * Created by Abel on 2015-08-15.
 */
public class OrderResource extends ResourceSupport {

    
    private Long resID;
    private String state;
    private String mode;
   
    private User user;

    public User getUser() {
        return user;
    }



    public Book getBook() {
        return book;
    }
    
    private Book book;


    private OrderResource(){}
    public OrderResource(Builder builder){

        resID = builder.resID;
        state = builder.state;
        mode = builder.mode;
        book = builder.book;
        user = builder.user;


    }
    public Long getID() {
        return resID;
    }

    public String getState() {
        return state;
    }

    public String getMode() {
        return mode;
    }


    public static class Builder{

        Long resID;
        private String state;
        private String mode;
        private User user;

        public Builder setBook(Book book) {
            this.book = book;
            return this;
        }

        private Book book;

        public Builder(User value){
            this.user = value;
        }

        public Builder ID(Long value){
            this.resID = value;
            return this;
        }

        public Builder state(String value){
            this.state = value;
            return this;
        }
        public Builder mode(String value){
            this.mode = value;
            return this;
        }


        public Builder copy(OrderResource va)
        {
            this.resID = va.resID;
            this.state = va.state;
            this.mode= va.mode;
            this.book = va.book;
            return this;
        }

        public OrderResource build() {
            return new OrderResource(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderResource OrderResource = (OrderResource) o;

        return !(resID != null ? !resID.equals(OrderResource.resID) : OrderResource.resID != null);

    }

    @Override
    public int hashCode() {
        return resID != null ? resID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrderResource{" +
                "ID=" + resID +
                ", State='" + state + '\'' +
                '}';
    }
}
