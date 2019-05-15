package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests  extends TestBase{


  @Test
  public void testContactCreationTests() throws Exception {
    app.goTo().gotoHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(before.get(before.size() - 1 ).getId(),"test3", "test21", "test6788", "98343434343", "shjkfjksfs@mail.ru", null);
    app.getContactHelper().createContact (contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);



    before.add(contact);
    Comparator<? super  ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);



  }
}
