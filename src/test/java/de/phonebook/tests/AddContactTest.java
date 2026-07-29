package de.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "qatiktak@gmail.com");
        type(By.name("password"), "Aa123456!");
        click(By.name("login"));
    }

    @Test
    public void addContaktPositiveTest() {
        click(By.cssSelector("[href='/add']"));

        type(By.xpath("//input[1]"), "Oliver");
        type(By.xpath("//input[2]"), "Kan");
        type(By.xpath("//input[3]"), "1234567890");
        type(By.xpath("//input[4]"), "kan@gmail.com");
        type(By.xpath("//input[5]"), "TelAviv");
        type(By.xpath("//input[6]"), "QA");

        click(By.cssSelector(".add_form__2rsm2 button"));

        Assert.assertTrue(verifyByName("Oliver"));
    }

    public boolean verifyByName(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

// удаляем созданный контакт (зачищаем после себя - button Remove)
    @AfterMethod
    public void postConditions() {
        //click on card
        click(By.cssSelector(".contact-item_card__2SOIM"));
//click on Remove button
        click(By.xpath("//button[.='Remove']"));

    }
}
