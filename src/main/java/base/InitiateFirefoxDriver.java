package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InitiateFirefoxDriver {


    public static final String DRIVER_PATH = "/Users/Florina_Florea/geckodriver";
    public static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    public static final String HOME_PAGE = "https://www.xm.com";
    public WebDriver driver;

    @BeforeMethod
    public void startFirefoxBrowser(){
        System.setProperty(FIREFOX_DRIVER, DRIVER_PATH);
        driver = new FirefoxDriver();
        driver.get(HOME_PAGE);
    }

    @AfterMethod
    public void closeFirefoxBrowser(){
        driver.close();
    }

}