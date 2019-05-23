package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().contacts().size() == 0){
            app.goTo().gotoHome();
            app.contact().create(new ContactData().withLastname("test33").withFirstname("test23").withAddress("test6788").withHome("98343434343").withEmail("shjkfjksfs@mail.ru"));
        }
    }
    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifyContact = before.iterator().next();
        app.goTo().gotoHome();
        ContactData contact = new ContactData()
                .withId(modifyContact.getId())
                .withLastname("test33")
                .withFirstname("test23")
                .withAddress("test6788")
                .withHome("98343434343")
                .withEmail("shjkfjksfs@mail.ru");
        app.contact().modify(contact);
        app.goTo().gotoHome();
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.withModify(modifyContact, contact)));
    }
}

