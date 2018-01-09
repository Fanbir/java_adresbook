package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import ru.qa.java.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactDate> before = app.contact().list();
    ContactDate contact = new ContactDate("Arsen", "Wenger",
            "London", "arsen_wenger@gmail.com",
            "+78304458345435");
    app.contact().create(contact);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);
    before.add(contact);
    Comparator<? super ContactDate> byId = (g1, g2) ->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
