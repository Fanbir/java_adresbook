package ru.qa.java.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.ContactData;
import ru.qa.java.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData().withLastName(split[0]).withFirstName(split[1]).withAddress(split[2])
              .withEmail1(split[3]).withEmail2(split[4])
              .withMobilePhone(split[6]).withWorkPhone(split[7]).withHomePhone(split[5])});
      line = reader.readLine();
    }
    return list.iterator();
  }




  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    Contacts before = app.contact().all();
   // File photo = new File("src/test/resources/photo.png");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() +1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

//  @Test
//  public void testCurrentDir() {
//    File currentDir = new File(".");
//    System.out.println(currentDir.getAbsolutePath());
//    File photo = new File("src/test/resources/photo.png");
//    System.out.println( photo.getAbsolutePath());
//    System.out.println(photo.exists() );
//  }
}
