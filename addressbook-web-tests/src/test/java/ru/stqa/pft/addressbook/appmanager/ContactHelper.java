package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submit() {
      click(By.linkText("Logout"));
    }

    public void fiilContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
      gotoContactcreat();
      click(By.name("home"));
      type(By.name("home"),contactData.getHome());
     type(By.name("email"),contactData.getEmail());
      submit();
    }

    public void gotoContactcreat() {
      click(By.linkText("add new"));
    }
}
