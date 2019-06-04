package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHome();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withLastname("test33")
                    .withFirstname("test23")
                    .withAddress("test6788")
                    .withHome("98343434343")
                    .withEmail("shjkfjksfs@mail.ru"), true);
        }
    }

    @Test
    public void testContactDeletionTests() throws Exception {
        Contacts before = app.contact().all();
        ContactData deleteContact = before.iterator().next();
        app.contact().delete(deleteContact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deleteContact)));
        verifyContactListInUI();
    }
}


