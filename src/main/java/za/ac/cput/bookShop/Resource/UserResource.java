package za.ac.cput.bookShop.Resource;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.bookShop.domain.Customer;
import za.ac.cput.bookShop.domain.UserAddress;

/**
 * Created by Abel on 2015-08-15.
 */
public class UserResource extends ResourceSupport {


    private Long resID;

    public String getUsername() {
        return username;
    }

    private String username;
    private String userPassword;

    private Customer c1;

    private UserAddress ad1;

    public String getUserPassword() {
        return userPassword;
    }

    public Customer getC1() {
        return c1;
    }

    public UserAddress getU1() {
        return ad1;
    }

    public UserResource(Builder build) {
        userPassword = build.userPassword;
        this.resID = build.resID;
        this.c1 = build.c1;
        this.ad1 = build.ad1;
        this.username = build.username;

    }

    private UserResource() {

    }

    public Long getID() {
        return resID;
    }


    public static class Builder {

        private String userPassword;
        private String username;
        private Long resID;
        private Customer c1;
        private UserAddress ad1;

        public Builder(String username) {
            this.username = username;

        }

        public Builder userPassword(String password) {
            this.userPassword = password;
            return this;
        }

        public Builder customerName(Customer c1) {
            this.c1 = c1;
            return this;
        }

        public Builder userAddress(UserAddress ua1) {
            this.ad1 = ua1;
            return this;

        }

        public Builder id(Long id) {
            this.resID = id;
            return this;
        }

        public Builder copy(UserResource u1) {
            this.username = u1.getUsername();
            this.userPassword = u1.getUserPassword();
            this.c1 = u1.c1;
            this.ad1 = u1.ad1;
            this.resID = u1.resID;
            return this;
        }

        public UserResource build() {
            return new UserResource(this);
        }
    }
}
