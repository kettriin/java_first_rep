package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeleteTest extends TestBase{


  @Test
  public void testGroupdelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnGropuPage();
    app.logout();
  }


}
