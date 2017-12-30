package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupDate("test1",null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnGroupPage();
  }

}
