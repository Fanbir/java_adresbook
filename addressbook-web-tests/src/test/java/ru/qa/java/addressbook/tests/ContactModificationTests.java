package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillConatctForm(new ContactDate("Arsen", "Wenger",
            "Ars", "Arsenal", "London", "Manager", "arsen_wenger@gmail.com",
            "+78304458345435", "1950", "England London", null, null, null), false);
    app.getContactHelper().submitContactMOdification();
    app.getNavigationHelper().returnHomePage();
  }
}
