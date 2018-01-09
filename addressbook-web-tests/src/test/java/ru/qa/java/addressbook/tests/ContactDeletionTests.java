package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePrecanditions() {
        app.contact().HomePage();
        if( app.contact().list().size() == 0) {
            app.contact().create(new ContactDate().withLastName("Arsen").withFirstName("Wenger")
                    .withAddress("London").withEmail("arsen_wenger@gmail.com").withPhone2("+78304458345435"));
        }
    }

    @Test
    public void ContactDeletionTests() {
        List<ContactDate> before = app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactDate> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
