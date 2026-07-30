package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    //before -login
    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        fillLoginRegisterForm("qatiktak@gmail.com", "Aa123456!");
        clickOnLoginButton();
    }

    @Test
    public void addContaktPositiveTest() {
        clickOnAddLink();
        fillAddContactForm("Oliver", "Kan", "1234567890", "kan@gmail.com", "TelAviv", "QA");
        clickOnSaveButton();
        Assert.assertTrue(verifyByName("Oliver"));
    }

    // удаляем созданный контакт (зачищаем после себя - button Remove)
    @AfterMethod
    public void postConditions() {
        removeContact();
    }


}
