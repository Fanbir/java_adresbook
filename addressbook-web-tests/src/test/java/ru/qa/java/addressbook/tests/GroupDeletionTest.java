package ru.qa.java.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;
import ru.qa.java.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

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
    Groups before = app.group().all();
    GroupDate deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() -1);
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }

}
