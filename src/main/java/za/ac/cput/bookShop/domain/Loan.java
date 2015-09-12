package za.ac.cput.bookShop.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String state;
    private String mode;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }



    public Book getBook() {
        return book;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;


    private Loan(){}
    public Loan(Builder builder){

        ID = builder.ID;
        state = builder.state;
        mode = builder.mode;
        book = builder.book;
        user = builder.user;


    }
    public Long getID() {
        return ID;
    }

    public String getState() {
        return state;
    }

    public String getMode() {
        return mode;
    }


    public static class Builder{

        Long ID;
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
            this.ID = value;
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


        public Builder copy(Loan va)
        {
            this.ID = va.ID;
            this.state = va.state;
            this.mode= va.mode;
            this.book = va.book;
            return this;
        }

        public Loan build() {
            return new Loan(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return !(ID != null ? !ID.equals(loan.ID) : loan.ID != null);

    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ID=" + ID +
                ", State='" + state + '\'' +
                '}';
    }
}
