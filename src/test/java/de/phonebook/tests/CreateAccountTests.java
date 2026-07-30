package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

   @Test(enabled = false)
    public void newUserRegisterPositiveTest(String email){
       clickOnLoginLink();
       fillLoginRegisterForm(newEmail(),"Aa123456!");
       clickOnRegistrationButton();
       Assert.assertTrue(isSignOutButtonPresent());
   }

    @Test
    public void existedUserRegisterNegativeTest(){
        clickOnLoginLink();
        fillLoginRegisterForm(newEmail(), "Aa123456!");
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
   }

}
