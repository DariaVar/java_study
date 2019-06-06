package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UsersData;

import javax.mail.MessagingException;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase{
    @BeforeMethod
    public void startMailServerAndEnsureUser() throws IOException, MessagingException {
        app.mail().start();
        if (app.db().users().size() == 1) {
            app.registration().start("Oleg", "oleg@localhost.localdomain");
            List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
            String confirmationLink = app.registration().findConfirmationLink(mailMessages, "oleg@localhost.localdomain");
            app.registration().finish(confirmationLink, "password");
        }
    }

    @Test
    public void testChangePassword() throws MessagingException, IOException {
        app.chpass().loginAsAdminAndManage();
        UsersData selectedUser = app.db().users().stream().filter((u) -> !u.getUsername().contains("administrator")).findAny().get();
        String email = selectedUser.getEmail();
        String username = selectedUser.getUsername();
        app.chpass().clickOnTestUserAndResetPsw(selectedUser);
        List<MailMessage> newMessages = app.mail().waitForMail(1, 10000);
        String resetLink = app.chpass().findResetPasswordLink(newMessages, email);
        app.chpass().changePassword(resetLink, "testpass");
        assertTrue(app.newSession().login(username, "testpass"));
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}

