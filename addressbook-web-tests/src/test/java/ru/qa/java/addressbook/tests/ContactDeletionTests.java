package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void ContactDeletionTests() {
        app.getContactHelper().gotoHomePage();
        if( ! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactDate("Arsen", "Wenger",
                    "London", "arsen_wenger@gmail.com",
                    "+78304458345435"));
        }
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deletionContact();
        app.getContactHelper().closeWindow();
        app.getNavigationHelper().returnHomePage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
