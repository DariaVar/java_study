package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests  extends TestBase{


  @Test
  public void testContactCreationTests() throws Exception {

    app.getContactHelper().gotoContactcreat();
    app.getContactHelper().fiilContactForm (new ContactData("test23", "test33", "test6788", "98343434343", "shjkfjksfs@mail.ru", "test1"), true);
    app.getContactHelper().submit();
  }
}
