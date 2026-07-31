package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

        //before - login, add contact
        @BeforeMethod
        public void precondition(){
            if (!app.getUser().isLoginLinkPresent()){
                app.getUser().clickOnSignOutButton();
            }

            app.getUser().clickOnLoginLink();
            app.getUser().fillLoginRegisterForm(new User()
                    .setEmail("qatiktak@gmail.com")
                    .setPassword("Aa123456!"));
            app.getUser().clickOnLoginButton();
            app.getContact().clickOnAddLink();
            app.getContact().fillAddContactForm(new Contact()
                    .setName("Oliver")
                    .setLastName("Kan")
                    .setPhone("1234567890")
                    .setEmail("kan@gmail.com")
                    .setAddress("TelAviv")
                    .setDescription("QA"));
            app.getContact().clickOnSaveButton();

        }
        @Test
        public void removeContactTest(){

            int sizeBefore = app.getContact().sizeOfContacts();
            app.getContact().removeContact();
            app.getContact().pause(1000);
            int sizeAfter = app.getContact().sizeOfContacts();
            Assert.assertEquals(sizeAfter,sizeBefore -1);
        }

}
