package za.ac.cput.bookShop.domain;

/**
 * Created by student on 2015-08-10.
 */
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String getUsername() {
        return username;
    }
    @Column(unique = true)
    private String username;
    private  String userPassword;
    @Embedded
    private Customer c1;
    @Embedded
    private UserAddress ad1;

    public String getUserPassword(){return userPassword;}
    public Customer getC1() {
        return c1;
    }

    public UserAddress getU1()
    {
        return ad1;
    }

    public User(Builder build)
    {
        userPassword = build.userPassword;
        this.id = build.id;
        this.c1 = build.c1;
        this.ad1= build.ad1;
        this.username = build.username;

    }

    private User()
    {

    }
    public Long getId()
    {
        return id;
    }


    public static class Builder
    {

        private String userPassword;
        private String username;
        private Long id;
        private Customer c1;
        private UserAddress ad1;

        public Builder(String username) {
            this.username = username;

        }
        public Builder userPassword(String password)
        {
            this.userPassword = password;
            return this;
        }
        public Builder userName(String name)
        {
            this.username = name;
            return this;
        }

        public Builder customerName(Customer c1)
        {
            this.c1 = c1;
            return this;
        }
        public Builder userAddress(UserAddress ua1)
        {
            this.ad1 = ua1;
            return this;

        }
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder copy(User u1)
        {
            this.username = u1.getUsername();
            this.userPassword = u1.getUserPassword();
            this.c1 = u1.c1;
            this.ad1 = u1.ad1;
            this.id = u1.id;
            return this;
        }

        public User build(){return new User(this);}
    }


}
