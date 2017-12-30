package ru.qa.java.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.qa.java.addressbook.model.ContactDate;

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

  public void selectContact() {
    click(By.name("selected[]"));
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

  public void gotoHomePage() {
    click(By.linkText("home"));
  }
  public void createContact(ContactDate contact) {
    gotoAddContact();
    fillConatctForm(contact);
    clickButtonAddContact();
    gotoHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]"));
  }
}
