package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InitiateSafariDriver {

    public static final String HOME_PAGE = "https://www.xm.com";
    public WebDriver driver;

    @BeforeMethod
    public void startSafariBrowser() {
        driver = new SafariDriver();
        driver.get(HOME_PAGE);
    }

    @AfterMethod
    public void closeSafariBrowser() {
        driver.close();
    }
}