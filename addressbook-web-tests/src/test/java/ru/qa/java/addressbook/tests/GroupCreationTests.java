package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

import java.util.List;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupDate("test1",null, null));
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
