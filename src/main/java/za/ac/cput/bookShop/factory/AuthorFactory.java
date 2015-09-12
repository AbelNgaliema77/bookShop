package za.ac.cput.bookShop.factory;

import za.ac.cput.bookShop.domain.Author;

import java.util.Map;

/**
 * Created by Abel on 2015-09-10.
 */
public class AuthorFactory {

    public static Author createBook(Map<String,String> value){
        return new Author.Builder(value.get("lName")).fName(value.get("fName")).build();
    }
}
