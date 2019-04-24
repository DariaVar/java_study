package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){

        app.getContactHelper().selectContact();
        app.getContactHelper(). initContactModification();
        app.getContactHelper().fiilContactForm(new ContactData("test23", "test33", "test6788", "98343434343", "shjkfjksfs@mail.ru", null), false);



    }
}
