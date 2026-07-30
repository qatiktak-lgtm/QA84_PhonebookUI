package de.phonebook.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.List;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isHomeComponentPresent(){
        return  isElementPresent(By.xpath("//h1[normalize-space()='No Contacts here!']"));
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        if(driver != null){
            driver.quit();
    }
}

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }
        else {
            return true;
        }
    }

    public String newEmail(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "karl" + i + "@gmail.com";
        return email;
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillLoginRegisterForm(String email, String password) {
        type(By.name("email"), email);
        type(By.name("password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login' ]"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillAddContactForm(String name, String lastName, String phone, String email, String address, String description) {

        type(By.xpath("//input[1]"), name);
        type(By.xpath("//input[2]"), lastName);
        type(By.xpath("//input[3]"), phone);
        type(By.xpath("//input[4]"), email);
        type(By.xpath("//input[5]"), address);
        type(By.xpath("//input[6]"), description);
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean verifyByName(String text) {
        List<WebElement> contacts  = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts() {
            if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
                return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
            }
            return  0;

        }
}
