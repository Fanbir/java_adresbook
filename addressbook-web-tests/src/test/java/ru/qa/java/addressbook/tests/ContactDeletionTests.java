package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePrecanditions() {
        app.contact().HomePage();
        if( app.contact().all().size() == 0) {
            app.contact().create(new ContactDate().withLastName("Arsen").withFirstName("Wenger")
                    .withAddress("London").withEmail("arsen_wenger@gmail.com").withPhone2("+78304458345435"));
        }
    }

    @Test
    public void ContactDeletionTests() {
        Set<ContactDate> before = app.contact().all();
        ContactDate deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }
}
