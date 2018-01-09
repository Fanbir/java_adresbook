package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

import java.util.Set;

public class GroupDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePrecanditions() {
    app.goTo().GroupPage();
    if(app.group().all().size() == 0) {
      app.group().create(new GroupDate().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Set<GroupDate> before = app.group().all();
    GroupDate deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(deletedGroup);
      Assert.assertEquals(before, after);
  }

}
