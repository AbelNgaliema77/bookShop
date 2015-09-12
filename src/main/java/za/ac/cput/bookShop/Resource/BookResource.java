package za.ac.cput.bookShop.Resource;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.bookShop.domain.Author;
import za.ac.cput.bookShop.domain.Publisher;


/**
 * Created by Abel on 2015-08-15.
 */
public class BookResource extends ResourceSupport {


    private Long resID;
    private String name;
    private double price;
    private String ISBN;
    private Author author;
    private Publisher publisher;
    private BookResource(){}
    public BookResource(Builder builder){
        this.resID = builder.resID;
        name = builder.name;

        price = builder.price;
        ISBN = builder.ISBN;
        author = builder.author;
        publisher =builder.publisher;

    }

    public Long getID() {
        return resID;
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
        private Long resID;
        private String name;
        private double price;
        private String ISBN;
        private Author author;


        private Publisher publisher;


        public Builder(String ISBN){
            this.ISBN = ISBN;
        }

        public Builder id(Long value){
            this.resID = value;
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

        public Builder copy(BookResource value){
            this.resID = value.resID;
            this.name = value.name;
            this.price = value.price;
            this.ISBN = value.ISBN;
            this.author = value.author;
            this.publisher = value.publisher;
            return this;
        }

        public BookResource build(){return new BookResource(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookResource BookResource = (BookResource) o;

        if (resID != null ? !resID.equals(BookResource.resID) : BookResource.resID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return resID != null ? resID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "za.ac.cput.BookResourceShop.domain.BookResource{" +
                "Id=" + resID +
                ", name='" + name + '\'' +
                '}';
    }
}
    

