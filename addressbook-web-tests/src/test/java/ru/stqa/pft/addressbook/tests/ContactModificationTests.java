package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHome();
        if(! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("test23", "test1", "test1", "test1", "test1@test.ru", "test1"), true);

        app.getContactHelper().selectContact();
        app.getContactHelper(). initContactModification();
        app.getContactHelper().fiilContactForm(new ContactData("test23", "test33", "test6788", "98343434343", "shjkfjksfs@mail.ru", null), false);



    }
}
}