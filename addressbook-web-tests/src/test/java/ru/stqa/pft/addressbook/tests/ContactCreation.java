package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreation extends TestBase {

    @Test
    public void testContactCreation() throws Exception {

        ContactData info = new ContactData("Глеб", "Харитонович",
                "Тропенко", "ZEDcandy", "Новосибирск, пр-кт Левашова, 15",
                "+79345768822", "tropenko@zcandy.com",
                "18", "December", "1991", "test991");

        //Предусловие
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getContactHelper().isThereTheGroup(info)) { //если группы, которую задаём, не существует,
            String newGroup = app.getContactHelper().getGroupName(info); // то вытаскиваем название этой группы и
            app.getGroupHelper().createGroup(new GroupData(newGroup, null, null)); // создаём новую группу с этим названием
        }
        //Шаги
        app.getNavigationHelper().returnHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(info, true);
        app.getContactHelper().approveContactCreation();
        app.getNavigationHelper1().returnHomePage();
        app.logout();
    }
}
