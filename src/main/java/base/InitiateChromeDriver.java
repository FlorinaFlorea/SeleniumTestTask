package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//Class used to initiate the driver and navigate to the required URL
public class InitiateChromeDriver {

    public static final String DRIVER_PATH = "/Users/Florina_Florea/chromedriver";
    public static final String CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String HOME_PAGE = "https://www.xm.com";
    public WebDriver driver;

    @BeforeMethod
     public void startChromeBrowser(){
         System.setProperty(CHROME_DRIVER, DRIVER_PATH);
         driver = new ChromeDriver();
         driver.get(HOME_PAGE);
     }

     @AfterMethod
     public void closeChromeBrowser(){
         driver.close();
     }
}
