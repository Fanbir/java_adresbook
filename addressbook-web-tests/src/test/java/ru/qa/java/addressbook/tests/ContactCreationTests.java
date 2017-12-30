package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;

import ru.qa.java.addressbook.model.ContactDate;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactDate("Arsen", "Wenger",
            "London", "arsen_wenger@gmail.com",
            "+78304458345435"));
  }
}
