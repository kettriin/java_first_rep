package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final String browser;
    private NavigationHelper navigationHelper1;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    public WebDriver wd;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    public JavascriptExecutor js;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        }
        else if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        }
        else if (browser == BrowserType.EDGE) {
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) wd;
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        navigationHelper1 = new NavigationHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void logout() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void closepopup() {wd.switchTo().alert().accept();}

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper1() {
        return navigationHelper1;
    }
}
