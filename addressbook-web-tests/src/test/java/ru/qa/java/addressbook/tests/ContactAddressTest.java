package ru.qa.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {
  @BeforeMethod
  public void ensurePrecanditions() {
    app.contact().HomePage();
    if( app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withLastName("Arsen").withFirstName("Wenger")
              .withAddress("Hornsey Rd, London N7 7AJ")
              .withMobilePhone("+7(8304458345435)").withWorkPhone("29-54").withHomePhone("23 154 64")
              .withEmail1("arsen_wenger@gmail.com").withEmai2("ars.W@mail.com"));
    }
  }

  @Test
  public void testContactAddress() {
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditFrom = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditFrom.getAddress()));
  }
}
