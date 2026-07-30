package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginRegisteredUserPositiveTest(){
        clickOnLoginLink();
        fillLoginRegisterForm("qatiktak@gmail.com", "Aa123456!");
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

}
