package de.phonebook.core;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

// если берем Suite то всегда должен быть ststic, а если открываем все не в одном окне а в разных то можно удалить static
    protected static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", "chrome")); //Browser.CHROME.browserName())

    @BeforeSuite
    public void setUp() {
        app.init();
    }


    @AfterSuite(enabled = true)
    public void tearDown(){
        app.stop();
    }

}
