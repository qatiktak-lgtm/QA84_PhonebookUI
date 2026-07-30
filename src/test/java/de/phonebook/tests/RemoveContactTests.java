package de.phonebook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

        //before - login, add contact
        @BeforeMethod
        public void precondition(){
            clickOnAddLink();
            fillLoginRegisterForm("qatiktak@gmail.com","Aa123456!");
            clickOnLoginButton();
            clickOnAddLink();
            fillAddContactForm("Oliver", "Kan", "1234567890", "kan@gmail.com", "TelAviv", "QA");
            clickOnSaveButton();

        }
        @Test
        public void removeContactTest(){

            int sizeBefore = sizeOfContacts();
            removeContact();
            pause(1000);
            int sizeAfter = sizeOfContacts();
            Assert.assertEquals(sizeAfter,sizeBefore -1);
        }

}
