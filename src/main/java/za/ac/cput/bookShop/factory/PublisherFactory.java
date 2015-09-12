package za.ac.cput.bookShop.factory;

import za.ac.cput.bookShop.domain.Publisher;

import java.util.Map;

/**
 * Created by Abel on 2015-09-10.
 */
public class PublisherFactory {

    public static Publisher createBook(Map<String,String> value){
        return new Publisher.Builder(value.get("name")).placeOfPublication(value.get("place")).build();
    }
}
