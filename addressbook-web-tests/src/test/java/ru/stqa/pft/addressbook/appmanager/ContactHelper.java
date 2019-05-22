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



    public void create(ContactData contactData) {
        goToHomePage();
        gotoContactcreat();
        fiilContactForm(new ContactData().withLastname("test33").withFirstname("test23").withAllEmails("test4"), true);
        initContactModification();
        contactCache = null;
        goToHomePage();

    }

    public void modify(ContactData contact) {
        goToHomePage();
        initContactModification(contact.getId());
        fiilContactForm(new ContactData().withLastname("test33").withFirstname("test23").withAllEmails("test4").withAllPhones("929209323"), false);
        updateContactButton();
    }


    public void delete(ContactData contactData) {

        selectContact(contactData.getId());
        deletContact();
        contactCache = null;
        waitDeletionContact();
        goToHomePage();
    }


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
        attach(By.name("photo"), contactData.getPhoto());
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

        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void initContactModification() {

        click(By.name("submit"));
    }

    public void waitDeletionContact() {
        wd.findElement(By.cssSelector("div.msgbox"));
    }

    public void updateContactButton() {
        click(By.name("update"));
    }

    private void clickOnHomePage() {
        click(By.linkText("home"));
    }

    private void selectContact(int id) {
        wd.findElement(By.id(Integer.toString(id))).click();
    }

    private void initContactModification(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }


    public void goToHomePage() {
        click(By.linkText("home"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


    private Contacts contactCache = null;

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));

        for (WebElement row :
                rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();

            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withAddress(address)
                    .withAllEmails(allEmails)
                    .withAllPhones(allPhones));
        }

        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
        return new ContactData()
                .withId(contact.getId())
                .withFirstname(firstname)
                .withLastname(lastname)
                .withAddress(address)
                .withHomePhone(home)
                .withMobilPhone(mobile)
                .withWorkPhone(work)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3);
    }
    private void  initContactModificationById(int id){
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row =checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}

