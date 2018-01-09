package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecanditions() {
    app.contact().HomePage();
    if(app.contact().list().size() == 0) {
      app.contact().create(new ContactDate("Arsen", "Wenger",
              "London", "arsen_wenger@gmail.com",
              "+78304458345435"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactDate> before = app.contact().list();
    int index = before.size() -1;
    ContactDate contact = new ContactDate(before.get(index).getId(),"Arsen", "Wenger",
            "London", "arsen_wenger@gmail.com",
            "+78304458345435");
    app.contact().modify(index, contact);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
