package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {
    @Test
    public void testContactPhones(){
        app.goTo().gotoHome();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        MatcherAssert.assertThat(contact.getHomePhone(), CoreMatchers.equalTo(contactInfoFromEditForm.getHomePhone()));
        MatcherAssert.assertThat(contact.getWorkPhone(), CoreMatchers.equalTo(contactInfoFromEditForm.getWorkPhone()));

    }
}
