package ru.qa.java.addressbook.generators;

import ru.qa.java.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getLastName(), contact.getFirstName(),
              contact.getAddress(), contact.getEmail1(), contact.getEmail2(), contact.getHomePhone(),
              contact.getMobilePhone(), contact.getWorkPhone()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withLastName(String.format("Arsen %s", i)).withFirstName(String.format("Wenger %s", i))
              .withAddress(String.format("Hornsey Rd, London N7 7AJ %s", i))
              .withEmail1(String.format("arsen_wenger%s@gmail.com", i)).withEmail2(String.format("ars.W%s@mail.com", i))
              .withMobilePhone(String.format("+7(8304458345435 %s)", i))
              .withWorkPhone(String.format("29-54 %s", i))
              .withHomePhone(String.format("23 154 64 %s", i)));
    }
    return contacts;
  }
}
