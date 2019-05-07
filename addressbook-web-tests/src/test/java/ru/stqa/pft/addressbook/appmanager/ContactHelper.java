package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submit() {
      click(By.linkText("Logout"));
    }

    public void fiilContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address"), contactData.getAddress());
        click(By.name("home"));
        type(By.name("home"), contactData.getHome());
        type(By.name("email"), contactData.getEmail());

    }
    public void gotoContactcreat() {
      click(By.linkText("add new"));
    }

    public void deletContact() {
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
      wd.switchTo().alert().accept();
    }

    public void selectContact() {
      wd.findElement(By.name("selected[]")).click();
    }

    public void initContactModification() {
        click(By.xpath("xpath=(//input[@name='submit'])[2])"));
    }


    public void createContact(ContactData contactData, boolean b) {
        gotoContactcreat();
        fiilContactForm (new ContactData("test23", "test33", "test6788", "98343434343", "shjkfjksfs@mail.ru", "test1"), true);
        initContactModification();
        submit();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));

    }
}
