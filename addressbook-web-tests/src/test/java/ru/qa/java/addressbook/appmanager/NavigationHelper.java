package ru.qa.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
   super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoAddContact() {
   click(By.linkText("add new"));
  }

  public void returnHomePage() {
   click(By.linkText("home"));
  }

  public void gotoHomePage() {
    click(By.xpath(".//*[@id='nav']/ul/li[1]/a"));
  }

  public void returnGroupPage() {
    click(By.linkText("groups"));
  }
}
