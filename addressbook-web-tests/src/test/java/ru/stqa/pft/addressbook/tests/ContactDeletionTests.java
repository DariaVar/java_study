package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletionTests() throws Exception {
      app.goTo().gotoHome();

    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test23", "test1", "test1", "test1", "test1@test.ru", "test1"));
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().deletContact();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1 );
       before.remove(before.size() - 1);
       Assert.assertEquals(after, before);
       }
  }
}

