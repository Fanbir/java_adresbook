package ru.qa.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.qa.java.addressbook.model.ContactDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
   super(wd);
  }

  public void fillConatctForm(ContactDate contactDate) {
    type(By.name("firstname"), contactDate.getFirstName());
    type(By.name("lastname"), contactDate.getLastName());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("email"), contactDate.getEmail());
    type(By.name("phone2"), contactDate.getPhone2());
  }

  public void clickButtonAddContact() {
   click(By.name("submit"));
  }

  public void returnHomePage() {
    if(isElementPresent(By.name("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deletionContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeWindow() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactMOdification() {
    click(By.name("update"));
  }

  public void gotoAddContact() {
    click(By.linkText("add new"));
  }

  public void HomePage() {
    click(By.linkText("home"));
  }

  public void create(ContactDate contact) {
    gotoAddContact();
    fillConatctForm(contact);
    clickButtonAddContact();
    HomePage();
  }
  public void modify(ContactDate contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillConatctForm(contact);
    submitContactMOdification();
    returnHomePage();
  }

  public void delete(ContactDate contact) {
    selectContactById(contact.getId());
    deletionContact();
    closeWindow();
    returnHomePage();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public  Set<ContactDate> all() {
    Set<ContactDate> contacts = new HashSet<ContactDate>();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']//tr[@name='entry']"));
    for (WebElement element: elements) {
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactDate().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address));
    }
    return contacts;
  }
}
