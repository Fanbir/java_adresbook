package ru.qa.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupData;
import ru.qa.java.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class GroupDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePrecanditions() {
    app.goTo().GroupPage();
    if(app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().сount(), equalTo(before.size() - 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }

}
