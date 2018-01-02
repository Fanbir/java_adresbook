package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    GroupDate group = new GroupDate("test1",null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    int max = 0;
    for (GroupDate g : after) {
      if(g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId(max);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
