package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;
import java.util.Set;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Set<GroupDate> before = app.group().all();
    GroupDate group = new GroupDate().withName("test2");
    app.group().create(group);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
