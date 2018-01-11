package ru.qa.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.qa.java.addressbook.model.ContactDate;
import ru.qa.java.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
   super(wd);
  }

  public void fillConatctForm(ContactDate contactDate) {
    type(By.name("firstname"), contactDate.getFirstName());
    type(By.name("lastname"), contactDate.getLastName());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("home"), contactDate.getHomePhone());
    type(By.name("mobile"), contactDate.getMobilePhone());
    type(By.name("work"), contactDate.getWorkPhone());
    type(By.name("email"), contactDate.getEmail1());
    type(By.name("email2"), contactDate.getEmail2());
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
    contactCash = null;
    HomePage();
  }
  public void modify(ContactDate contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillConatctForm(contact);
    submitContactMOdification();
    contactCash = null;
    returnHomePage();
  }

  public void delete(ContactDate contact) {
    selectContactById(contact.getId());
    deletionContact();
    closeWindow();
    contactCash = null;
    returnHomePage();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }
  private Contacts contactCash = null;

  public Contacts all() {
    if(contactCash!= null) {
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']//tr[@name='entry']"));
    for (WebElement element: elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      contactCash.add(new ContactDate().withId(id).withFirstName(firstName)
              .withLastName(lastName).withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return new Contacts(contactCash);
  }

  public ContactDate infoFromEditForm(ContactDate contact) {
    initContactModificationById(contact.getId());
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    wd.navigate().back();
    return new ContactDate().withId(contact.getId()).withFirstName(firstName)
            .withLastName(lastName).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail1(email1).withEmai2(email2).withAddress(address);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
//
//    wd.findElement(By.xpath(String.format("//input[value='%s']/../../td[8/a]",id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[value='%s']]/td[8/a",id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }
}
