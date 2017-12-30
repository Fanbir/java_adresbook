package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

public class ContactDeletionTests extends TestBase {

    @Test
    public void ContactDeletionTests() {
        app.getContactHelper().gotoHomePage();
        if( ! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactDate("Arsen", "Wenger",
                    "London", "arsen_wenger@gmail.com",
                    "+78304458345435"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deletionContact();
        app.getContactHelper().closeWindow();
        app.getNavigationHelper().returnHomePage();
    }
}
