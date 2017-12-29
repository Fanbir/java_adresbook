package ru.qa.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.java.addressbook.model.GroupDate;

public class GroupHelper  extends  HelperBase{

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupDate groupDate) {
    type(By.name("group_name"), groupDate.getName());
    type(By.name("group_header"), groupDate.getHeader());
    type(By.name("group_footer"), groupDate.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnGroupPage() {
    click(By.linkText("groups"));
  }

  public void deletedSelectedGroup() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.xpath(".//*[@id='content']/form/span[1]/input"));
  }
}