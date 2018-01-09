package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

import java.util.HashSet;
import java.util.List;

public class GroupModoficationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecanditions() {
    app.goTo().GroupPage();
    if(app.group().list().size() == 0) {
      app.group().create(new GroupDate().withName(""));
    }
  }

  @Test
  public void testGroupModification() {
    List<GroupDate> before = app.group().list();
    int index = before.size()-1;
    GroupDate group = new GroupDate()
            .withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(index, group);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index );
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
