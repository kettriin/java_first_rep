package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreation extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Глеб", "Харитонович",
                "Тропенко", "ZEDcandy", "Новосибирск, пр-кт Левашова, 15",
                "+79345768822", "tropenko@zcandy.com",
                "18", "December", "1991"));
        app.getContactHelper().approveContactCreation();
        app.getNavigationHelper1().returnHomePage();
        app.logout();
    }
}
