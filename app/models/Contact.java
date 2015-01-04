package models;

import play.db.ebean.Model;
import javax.persistence.*;
import static play.data.validation.Constraints.*;

/**
 * Created by anderson on 04/01/15.
 */

@Entity
public class Contact extends Model {

    public static Finder<Integer, Contact> finder =
            new Finder<Integer, Contact>(Integer.class, Contact.class);

    @Id
    Integer id;

    @Required
    String name;

    @Required
    @Email
    String emailAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
