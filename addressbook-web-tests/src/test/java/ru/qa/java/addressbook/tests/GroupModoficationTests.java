package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.Set;

public class GroupModoficationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecanditions() {
    app.goTo().GroupPage();
    if(app.group().all().size() == 0) {
      app.group().create(new GroupDate().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Set<GroupDate> before = app.group().all();
    GroupDate modifiedGroup = before.iterator().next();
    GroupDate group = new GroupDate()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
