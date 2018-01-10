package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Set<ContactDate> before = app.contact().all();
    ContactDate contact = new ContactDate()
            .withLastName("Arsen").withFirstName("Wenger")
            .withAddress("London").withEmail("arsen_wenger@gmail.com").withPhone2("+78304458345435");
    app.contact().create(contact);
    Set<ContactDate> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() +1);
    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
