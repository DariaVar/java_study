package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {


    private boolean creation;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void fiilContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).getOptions().get(1).click();
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
        click(By.cssSelector("[value='Delete']"));
        wd.switchTo().alert().accept();

    }


    public void selectContactById(int index) {

        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();}

    public void initContactModification() {

        click(By.name("submit"));


    }
    public void waitDeletionContact(){
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void updateContactButton() {
        click(By.name("update"));
    }


    public void create(ContactData contactData) {
        gotoContactcreat();
        fiilContactForm (new ContactData().withLastname("test33").withFirstname( "test23"), true);
        initContactModification();
        contactCache = null;
        clickOnHomePage();
    }
    public void modify( ContactData contact) {
        goToHomePage();
        initContactModification(contact.getId());
       fiilContactForm (new ContactData().withLastname("test33").withFirstname( "test23"), false);
        updateContactButton();

    }
    private void clickOnHomePage() {
        click(By.linkText("home"));
    }


    public void delete(ContactData contactData) {

        selectContact(contactData.getId());
        deletContact();
        contactCache = null;
        waitDeletionContact();
        goToHomePage();


    }
    private void selectContact(int id) {
        wd.findElement(By.id(Integer.toString(id))).click();
    }

    private void initContactModification(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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


