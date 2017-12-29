package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void ContactDeletionTests() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deletionContact();
        app.getContactHelper().closeWindow();
        app.getNavigationHelper().returnHomePage();
    }

}
