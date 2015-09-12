package za.ac.cput.bookShop.domain;

/**
 * Created by Abel on 2015-08-10.
 */
import java.io.Serializable;



import java.lang.String;
import javax.persistence.*;
@Embeddable
public class Customer implements Serializable
{
    public String getC_name() {
        return c_name;
    }

    private String c_name;

    public String getC_surname() {
        return c_surname;
    }

    private String c_surname;

    private Customer()
    {

    }
    public Customer(Builder build)
    {
        this.c_name = build.c_name;
        this.c_surname = build.c_surname;

    }

    public static class Builder
    {
        private String c_name;
        private String c_surname;

        public Builder(String name)
        {
            this.c_name = name;
        }
        public Builder c_surname(String surname){
            this.c_surname = surname;
            return this ;
        }

        public Builder c_name(String name)
        {
            this.c_name = name;
            return this ;
        }

        public Builder copy(Customer cus)
        {
            this.c_name = cus.c_name;
            this.c_name = cus.c_surname;
            return this;
        }
        public Customer build()
        {
            return new Customer(this);
        }


    }
}

