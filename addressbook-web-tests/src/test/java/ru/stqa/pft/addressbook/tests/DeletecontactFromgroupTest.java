package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletecontactFromgroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Test1").withHeader("testers").withFooter("t66"));
        }
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/frog.jpg");
        if (app.db().contacts().size() == 0) {
            app.goTo().gotoHome();
            app.contact().create(new ContactData().withFirstname("test12").withLastname("test23").withAddress("test1488")
                    .withEmail("test@mail.ru").withPhoto(photo).inGroup(groups.iterator().next()), true);
        }
    }
    @Test
    public void deleteContactFromGroupTest() {
        Contacts contacts = app.db().contacts();
        ContactData editedContact = contacts.iterator().next();
        int idEditedContact = editedContact.getId();
        Groups contactGroupsBefore = editedContact.getGroups();
        if (contactGroupsBefore.size() == 0) {
            Groups groups = app.db().groups();
            GroupData addToGroup = groups.stream().iterator().next();
            app.goTo().gotoHome();
            app.contact().addToGroup(addToGroup, editedContact);
            app.db().contacts();
        }
        contactGroupsBefore = editedContact.getGroups();
        GroupData group = contactGroupsBefore.iterator().next();
        app.goTo().gotoHome();
        app.contact().removeFromGroup(editedContact, group);

        Contacts after = app.db().contacts();
        ContactData contactAfter = after.stream().filter(data -> Objects.equals(data.getId(), idEditedContact)).findFirst().get();
        Groups contactGroupsAfter = contactAfter.getGroups();
        assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.without(group)));
        verifyContactListInUI();
    }
}
