package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testDeleteContact(){
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.closepopup();
        app.getNavigationHelper().waitForAnswer(); //ждём, пока сайт автоматом вернётся на homepage
        app.logout();
    }


}
