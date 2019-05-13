package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification(){
        app.goTo().gotoHome();
        if(! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("test23", "test1", "test1", "test1", "test1@test.ru", "test1"));
            List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper(). initContactModification();
        ContactData contact = new ContactData(before.get(before.size() - 1 ).getId(),"test23", "test33", "test6788", "98343434343", "shjkfjksfs@mail.ru", null);
        app.getContactHelper().fiilContactForm (contact);
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size() );
            before.remove(before.size() -1);
            before.add(contact);
            Comparator<? super  ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);
    }
}
}