package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.NoSuchElementException;
//import java.util.NoSuchElementException;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) { super(wd);
    }

    public void approveContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
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

        if (creation) {
            try {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            } catch (NoSuchElementException e) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("[none]");
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    private void bday(By period, String valuename) {
        new Select(wd.findElement(period)).selectByVisibleText(valuename);
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void selectIDContact() {
        click(By.id("1"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void modifyContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void updateModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void createContact(ContactData contact, Boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        approveContactCreation();
        returnHomePage();
    }

    public void returnHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        } else {
            click(By.linkText("home page"));
        }
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isThereTheGroup(ContactData contactData) {
        if(wd.findElement(By.xpath("//html")).getText().contains(contactData.getGroup())){
            return true;
        }
        return false;
    }


    public String getGroupName(ContactData contactData) {
        return (contactData.getGroup());
    }
}

