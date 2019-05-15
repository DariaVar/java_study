package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoHome();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withLastname("test1488"));

        }}

  @Test
  public void testContactDeletionTests() throws Exception {

     Contacts before = app.contact().all();
      ContactData deleteContact = before.iterator().next();

      app.contact().delete(deleteContact);
      assertThat(app.contact().count(), equalTo(before.size() - 1 ));
      Contacts after = app.contact().all();


      MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deleteContact)));
       }

}


