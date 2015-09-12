package za.ac.cput.bookShop.factory;


import za.ac.cput.bookShop.domain.Author;
import za.ac.cput.bookShop.domain.Book;
import za.ac.cput.bookShop.domain.Publisher;

import java.util.List;
import java.util.Map;


public class BookFactory {

    public static Book createBook(Map<String,String> value,double price,Publisher publisher,Author author){
        return new Book.Builder(value.get("isbn"))
                .name(value.get("name"))
                .price(price)
                .authors(author).
                 publisher(publisher)
                .build();
    }

}

