package za.ac.cput.bookShop.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/26.
 */
@Embeddable
public class UserAddress implements Serializable {
    private String city;
    private String country;
    private int postal;
    private UserAddress()
    {

    }
    public UserAddress(Builder build)
    {
        this.city = build.city;
        this.country = build.country;
        this.postal = build.postal;

    }
    public String getCity(){return city;}
    public String getCountry(){ return country;}
    public int getPostal(){return postal;}

    public static class Builder
    {
        private String city;
        private String country;
        private int postal;

        public Builder(int postal)
        {
            this.postal = postal;

        }
        public Builder city(String ct)
        {
            this.city= ct;
            return this;

        }
        public Builder country(String cntry)
        {
            this.country = cntry;
            return this;

        }
        public Builder copy(UserAddress ua)
        {
            this.city = ua.getCity();
            this.country = ua.getCountry();
            this.postal = ua.getPostal();
            return this;
        }
        public UserAddress build(){return new UserAddress(this);}


    }
}