package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) { super(wd);
    }

    public void approveContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        click(By.name("firstname"));
        type(By.name("firstname"), contactData.name());
        type(By.name("middlename"), contactData.middlename());
        type(By.name("lastname"), contactData.lastname());
        click(By.name("company"));
        type(By.name("company"), contactData.company());
        click(By.name("address"));
        type(By.name("address"), contactData.address());
        click(By.name("mobile"));
        type(By.name("mobile"), contactData.mobilephonenum());
        click(By.name("email"));
        type(By.name("email"), contactData.emailaddress());
        click(By.name("bday"));
        bday(By.name("bday"), contactData.birthday());
        click(By.name("bmonth"));
        bday(By.name("bmonth"), contactData.birthmonth());
        click(By.name("byear"));
        type(By.name("byear"), contactData.birthyear());
    }

    private void bday(By period, String valuename) {
        new Select(wd.findElement(period)).selectByVisibleText(valuename);
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }
}
