package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    private boolean creation;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submit() {
      click(By.linkText("Logout"));
    }

    public void fiilContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertTrue(isElementPresent(By.name("new_group")));
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
      click(By.xpath("//input[@value='Delete']"));

    }

    public void selectContact(int index) {

        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void selectContactById(int id) {

        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactModification() {

        click(By.name("submit"));


    }
    public void waitDeletionContact(){
        wd.findElement(By.cssSelector("div.msgbox"));
    }


    public void create(ContactData contactData) {
        gotoContactcreat();
        fiilContactForm (new ContactData().withLastname("test33").withFirstname( "test23"));
        initContactModification();
        contactCache = null;
        clickOnHomePage();
    }
    public void modify( ContactData contact) {
        goToHomePage();
        selectContactById(contact.getId());
       fiilContactForm (contact);
        initContactModification();
        contactCache = null;
        clickOnHomePage();
    }
    private void clickOnHomePage() {
        click(By.linkText("home"));
    }


    public void delete(ContactData deleteContact) {
        goToHomePage();
        isThereAContact();
        deletContact();


    }
    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));

    }

    public void goToHomePage() {
        click(By.linkText("home"));
    }

    public int count() {
        return  wd.findElements(By.name("selected[]")).size();
    }


    private Contacts contactCache =null;
    public Contacts all() {
            if (contactCache != null) {
                return new Contacts(contactCache);
            }
            contactCache = new Contacts();
            List<WebElement> elemets = wd.findElements(By.xpath("//tr[@name='entry']"));

            for (WebElement element : elemets) {
                List<WebElement> elements1 = element.findElements(By.tagName("td"));
                String firstName = elements1.get(2).getText();
                String lastName = elements1.get(1).getText();

                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
            }

            return contactCache;
        }
}


