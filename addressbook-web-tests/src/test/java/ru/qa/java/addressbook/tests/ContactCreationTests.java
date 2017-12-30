package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;

import ru.qa.java.addressbook.model.ContactDate;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoAddContact();
    app.getContactHelper().fillConatctForm(new ContactDate("Arsen",
            "Wenger", "Ars", "Arsenal", "London",
            "Manager", "arsen_wenger@gmail.com", "+78304458345435",
            "1950", "England London", "4 space", "Emirets", "test1"), true);
    app.getContactHelper().clickButtonAddContact();
  }

}
