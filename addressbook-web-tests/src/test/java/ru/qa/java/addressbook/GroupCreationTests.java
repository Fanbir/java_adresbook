package ru.qa.java.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupDate("test1", "test1", "test1"));
    submitGroupCreation();
    returnGroupPage();
  }

}
