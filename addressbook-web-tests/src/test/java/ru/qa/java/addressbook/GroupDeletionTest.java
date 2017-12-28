package ru.qa.java.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testGroupDeletion() {
    gotoGroupPage();
    selectGroup();
    deletedSelectedGroup();
    returnGroupPage();
  }

}
