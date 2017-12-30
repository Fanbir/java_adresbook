package ru.qa.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.java.addressbook.model.ContactDate;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
   super(wd);
  }

  public void fillConatctForm(ContactDate contactDate) {
    type(By.name("firstname"),contactDate.getFirstName());
    type(By.name("lastname"),contactDate.getLastName());
    type(By.name("nickname"),contactDate.getNickName());
    type(By.name("company"),contactDate.getCompany());
    type(By.name("address"),contactDate.getAddress());
    type(By.name("work"),contactDate.getWork());
    type(By.name("email"),contactDate.getEmail());
    type(By.name("mobile"),contactDate.getMobile());
    type(By.name("byear"),contactDate.getByEar());
    type(By.name("address2"),contactDate.getAddress2());
    type(By.name("notes"),contactDate.getNotes());
    type(By.name("phone2"),contactDate.getPhone2());
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
}
