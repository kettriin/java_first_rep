package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testDeleteContact(){
        app.getGroupHelper().selectGroup();
        app.getContactHelper().deleteSelectedContact();
        app.closepopup();
        app.getNavigationHelper().waitForAnswer(); //ждём, пока сайт автоматом вернётся на homepage
        app.logout();
    }


}
