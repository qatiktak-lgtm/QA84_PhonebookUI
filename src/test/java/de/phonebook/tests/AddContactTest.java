package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    //before -login
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("qatiktak@gmail.com")
                .setPassword("Aa123456!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContaktPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Kan").setPhone("1234567890")
                .setEmail("kan@gmail.com").setAddress("TelAviv")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyByName("Oliver"));
    }

    // удаляем созданный контакт (зачищаем после себя - button Remove)
    @AfterMethod
    public void postConditions() {
        app.getContact().removeContact();
    }


}
