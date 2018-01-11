package ru.qa.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

  @BeforeMethod
  public void ensurePrecanditions() {
    app.contact().HomePage();
    if( app.contact().all().size() == 0) {
      app.contact().create(new ContactDate().withLastName("Arsen").withFirstName("Wenger")
              .withAddress("Hornsey Rd, London N7 7AJ")
              .withMobilePhone("+78304458345435").withWorkPhone("2954").withHomePhone("231546-4")
              .withEmail1("arsen_wenger@gmail.com").withEmai2("ars.W@mail.com"));
    }
  }

  @Test
  public void testContactPhones() {
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditFrom = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditFrom.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditFrom.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditFrom.getWorkPhone())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]","");
  }

}
