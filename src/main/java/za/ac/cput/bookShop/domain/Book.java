package za.ac.cput.bookShop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    @Column(unique = true)
    private String ISBN;
    @Embedded
    private Author author;
    @Embedded
    private Publisher publisher;

    private Book(){}
    public Book(Builder builder){
        this.id = builder.id;
        name = builder.name;

        price = builder.price;
        ISBN = builder.ISBN;
        author = builder.author;
        publisher =builder.publisher;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public static class Builder{
        private Long id;
        private String name;
        private double price;
        private String ISBN;
        private Author author;


        private Publisher publisher;


        public Builder(String ISBN){
            this.ISBN = ISBN;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }

        public Builder price(double value){
            this.price = value;
            return this;
        }

        public Builder publisher(Publisher value){
            this.publisher = value;
            return this;
        }

        public Builder authors(Author value){
            this.author = value;
            return this;
        }

        public Builder copy(Book value){
            this.id = value.id;
            this.name = value.name;
            this.price = value.price;
            this.ISBN = value.ISBN;
            this.author = value.author;
            this.publisher = value.publisher;
            return this;
        }

        public Book build(){return new Book(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "za.ac.cput.bookShop.domain.Book{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
