package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testDeleteContact(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Глеб", "Харитонович",
                    "Тропенко", "ZEDcandy", "Новосибирск, пр-кт Левашова, 15",
                    "+79345768822", "tropenko@zcandy.com",
                    "18", "December", "1991", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.closepopup();
        app.getNavigationHelper().waitForAnswer(); //ждём, пока сайт автоматом вернётся на homepage
        app.logout();
    }


}
