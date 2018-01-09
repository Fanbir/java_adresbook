package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();
    if( ! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactDate("Arsen", "Wenger",
              "London", null,
              null));
    }
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().initContactModification();
    ContactDate contact = new ContactDate(before.get(before.size()-1).getId(),"Arsen", "Wenger", "London", "arsen_wenger@gmail.com","+78304458345435");
    app.getContactHelper().fillConatctForm(contact);
    app.getContactHelper().submitContactMOdification();
    app.goTo().returnHomePage();
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() -1 );
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
