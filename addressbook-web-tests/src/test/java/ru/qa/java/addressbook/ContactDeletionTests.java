package ru.qa.java.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void ContactDeletionTests() {
        gotoHomePage();
        selectContact();
        deletionContact();
        closeWindow();
        returnHomePage();
    }

}
