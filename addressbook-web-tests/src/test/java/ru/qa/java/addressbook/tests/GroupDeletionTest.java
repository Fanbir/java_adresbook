package ru.qa.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.java.addressbook.model.GroupDate;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()) {
          app.getGroupHelper().createGroup(new GroupDate("test1",null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deletedSelectedGroup();
    app.getGroupHelper().returnGroupPage();
  }

}
