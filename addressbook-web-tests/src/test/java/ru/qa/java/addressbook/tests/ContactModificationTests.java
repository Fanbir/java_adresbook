package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;
import java.util.HashSet;
import java.util.Set;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecanditions() {
    app.contact().HomePage();
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withLastName("Arsen").withFirstName("Wenger")
              .withAddress("London").withEmail("arsen_wenger@gmail.com").withPhone2("+78304458345435"));
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactDate> before = app.contact().all();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate()
            .withId(modifiedContact.getId()).withLastName("Arsen").withFirstName("Wenger")
            .withAddress("London").withEmail("arsen_wenger@gmail.com").withPhone2("+78304458345435");
    app.contact().modify(contact);
    Set<ContactDate> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
