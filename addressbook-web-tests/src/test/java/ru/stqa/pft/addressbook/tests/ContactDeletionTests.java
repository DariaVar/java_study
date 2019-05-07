package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletionTests() throws Exception {
    app.getNavigationHelper().gotoHome();
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test23", "test1", "test1", "test1", "test1@test.ru", "test1"), true);
    app.getContactHelper().selectContact();
    app.getContactHelper().deletContact();
  }
}}

