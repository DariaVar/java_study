package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests  extends TestBase{


  @Test
  public void testContactCreationTests() throws Exception {
    app.goTo().gotoHome();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withLastname("test33").withFirstname("test23");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();





    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



  }


  @Test
  public void testBadContactCreationTests() throws Exception {
    app.goTo().gotoHome();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withLastname("test33").withFirstname("test23");
    app.contact().create(contact);

    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();


    assertThat(after, equalTo(before));



  }
}
