import models.Contact;
import play.Application;
import play.GlobalSettings;

/**
 * Created by anderson on 04/01/15.
 */
public class Global extends GlobalSettings {

    @Override
    public void onStart(Application application) {
        Contact firstContact = new Contact();
        firstContact.setName("Anderson Anzileiro");
        firstContact.setEmailAddress("anderson.anzileiro@gmail.com");
        firstContact.save();
    }
}
