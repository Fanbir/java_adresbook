package ru.qa.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;
import ru.qa.java.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecanditions() {
    app.contact().HomePage();
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withLastName("Arsen").withFirstName("Wenger")
              .withAddress("London").withEmail("arsen_wenger@gmail.com")
              .withMobilePhone("+78304458345435").withWorkPhone("2954"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate()
            .withId(modifiedContact.getId()).withLastName("Arsen").withFirstName("Wenger")
            .withAddress("London").withEmail("arsen_wenger@gmail.com")
            .withMobilePhone("+78304458345435").withWorkPhone("2954").withHomePhone("231546-4");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }
}
