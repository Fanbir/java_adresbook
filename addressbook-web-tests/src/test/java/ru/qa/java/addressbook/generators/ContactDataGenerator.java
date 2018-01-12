package ru.qa.java.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.qa.java.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;


  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException e) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    save(contacts, new File(file));
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
