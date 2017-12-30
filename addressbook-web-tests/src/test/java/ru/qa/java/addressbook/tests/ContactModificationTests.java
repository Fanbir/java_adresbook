package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();
    if( ! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactDate("Arsen", "Wenger",
              "London", "arsen_wenger@gmail.com",
              "+78304458345435"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillConatctForm((new ContactDate("Arsen", "Wenger", "London", "arsen_wenger@gmail.com","+78304458345435")));
    app.getContactHelper().submitContactMOdification();
    app.getNavigationHelper().returnHomePage();
  }
}
