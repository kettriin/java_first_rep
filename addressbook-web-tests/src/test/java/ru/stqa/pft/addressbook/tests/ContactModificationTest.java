package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void ContactModificationTest(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Глеб", "Харитонович",
                    "Тропенко", "ZEDcandy", "Новосибирск, пр-кт Левашова, 15",
                    "+79345768822", "tropenko@zcandy.com",
                    "18", "December", "1991", "test1"));
        }

        app.getContactHelper().modifyContact();
        app.getContactHelper().fillContactForm(new ContactData("Артём", "Александрович", "Бантуков",
                                                               "PlayRix", "г.Киров, ул.Большая Московская, д.11",
                                                               "+79330445566", "art@gallery.com",
                                                               "1", "April", "1994", null), false);
        app.getContactHelper().updateModification();
        app.getNavigationHelper().returnHomePage();
        app.logout();
    }
}
