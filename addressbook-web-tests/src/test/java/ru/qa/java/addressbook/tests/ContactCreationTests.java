package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;
import ru.qa.java.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactDate contact = new ContactDate()
            .withLastName("Arsen").withFirstName("Wenger")
            .withAddress("Hornsey Rd, London N7 7AJ")
            .withMobilePhone("+78304458345435").withWorkPhone("2954").withHomePhone("231546-4")
            .withEmail1("arsen_wenger@gmail.com").withEmai2("ars.W@mail.com");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
