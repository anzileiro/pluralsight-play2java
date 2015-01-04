package controllers;

import play.mvc.*;
import views.html.*;
import java.util.*;
import models.*;
import play.data.*;

/**
 * Created by anderson on 03/01/15.
 */


public class Contacts extends Controller {

    static Form<Contact> contactForm = new Form<Contact>(Contact.class);

    public static Result index(){

        //List<String> names = Arrays.asList("Anderson", "Carol", "Jaqueline", "Jairo", "Andrea", "Marcus");
        List<Contact> contacts = Contact.finder.all();
        /*
        if(!session().containsKey("counter")){
            session("counter", "0");
        }

        String currentStringValue = session("counter");
        Integer currentValue = Integer.parseInt(currentStringValue);
        Integer newValue = currentValue + 1;
        session("counter", newValue.toString());
        */

        return ok(index.render(contacts, contactForm));
    }

    public static Result create(){

        Form<Contact> form = contactForm.bindFromRequest(request());

        if (!form.hasErrors()){
            form.get().save();
            return redirect(routes.Contacts.index());
        }else {
            return badRequest(index.render(Contact.finder.all(), form));
        }
    }

    public static Result edit(int id){
        Contact contact = Contact.finder.byId(id);

        if(contact == null){
            return redirect(routes.Contacts.index());
        }else{
            Form<Contact> form = contactForm.fill(contact);
            return ok(edit.render(id, form));
        }
    }

    public static Result update(int id){
        Form<Contact> form = contactForm.bindFromRequest(request());

        if (!form.hasErrors()){
            form.get().update(id);
            return redirect(routes.Contacts.index());
        }else {
            return badRequest(edit.render(id, form));
        }

    }

    public static Result delete(int id){

        Contact contact = Contact.finder.byId(id);

        if (contact != null){
            contact.delete();
        }

        return redirect(routes.Contacts.index());
    }
}
