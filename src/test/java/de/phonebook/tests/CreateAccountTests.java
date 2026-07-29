package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

   @Test(enabled = false)
    public void newUserRegisterPositiveTest(){
       //click on Login link

       click(By.cssSelector("[href='/login' ]"));
       type(By.name("email"), newEmail());
       type(By.name("password"), "Aa123456!");
       click(By.name("registration"));
       Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
   }

    @Test
    public void existedUserRegisterNegativeTest(){
       //click on Login link
        click(By.cssSelector("[href='/login' ]"));
        type(By.name("email"), "qatiktak@gmail.com");
        type(By.name("password"), "Aa123456!");
        click(By.name("registration"));
        Assert.assertTrue(isAlertPresent());
   }

}
