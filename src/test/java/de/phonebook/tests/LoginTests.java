package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginRegisteredUserPositiveTest(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "qatiktak@gmail.com");
        type(By.name("password"), "Aa123456!");
        click(By.name("login"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }
}
