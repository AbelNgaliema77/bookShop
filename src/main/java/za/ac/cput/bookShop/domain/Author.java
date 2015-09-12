package za.ac.cput.bookShop.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Embeddable
public class Author implements  Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;*/
    private String lName;
    private String fName;

    private Author(){

    }

    public Author(Builder builder){
        lName = builder.lName;
        fName = builder.fName;
    }

    public String getLName() {
        return lName;
    }

    public String getFName() {
        return fName;
    }

    public static class Builder{

        private String lName;
        private String fName;
        /*public Builder(String lName, String fName){
            this.lName = lName;
            this.fName = fName;
        }*/
        public Builder(String ln)
        {
            lName = ln;
        }
        public Builder lName(String value){
            this.lName = value;
            return this;
        }

        public Builder fName(String value){
            this.fName = value;
            return this;
        }

        public Builder copy(Author value){
            this.fName = value.fName;
            this.lName = value.lName;
            return this;
        }

        public Author build(){
            return new Author(this);
        }

    }
//
//   @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Author author = (Author) o;
//
//        if (ID != null ? !ID.equals(author.ID) : author.ID != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return ID != null ? ID.hashCode() : 0;
//    }
//
//    @Override
//    public String toString() {
//        return "Author{" +
//                "ID='" + ID + '\'' +
//                ", lName='" + lName + '\'' +
//                ", fName='" + fName + '\'' +
//                '}';
//    }
}
