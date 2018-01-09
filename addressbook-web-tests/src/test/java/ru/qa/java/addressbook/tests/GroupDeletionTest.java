package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

import java.util.List;

public class GroupDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePrecanditions() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupDate("test1",null, null));
    }
  }

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()) {
          app.getGroupHelper().createGroup(new GroupDate("test1",null, null));
    }
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().deletedSelectedGroup();
    app.getGroupHelper().returnGroupPage();
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(before.size()-1);
      Assert.assertEquals(before, after);
  }

}
