package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

public class ContactModificationTests extends TestBase {

@BeforeMethod
public void ensurePreconditions(){
    app.goTo().gotoHome();
    if (app.contact().all().size() == 0){
        app.contact().create(new ContactData().withLastname("test1488"));

    }}


    @Test
    public void testContactModification(){

           Contacts before = app.contact().all();
        ContactData modifyContact = before.iterator().next();

            ContactData contact = new ContactData()
                    .withId(modifyContact.getId()).withLastname("test1488").withFirstname( "test33").withAddress("test6788").withHome("98343434343").withEmail("shjkfjksfs@mail.ru");
            app.contact().modify(contact);

        Contacts after = app.contact().all();
            Assert.assertEquals(after.size(), before.size());


        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifyContact).withAdded(contact)));

        }
    }

