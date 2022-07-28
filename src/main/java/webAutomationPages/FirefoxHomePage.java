package webAutomationPages;

import base.InitiateFirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

//The home page displayed for the user when navigating to the URL
public class FirefoxHomePage extends InitiateFirefoxDriver {

    WebDriver driver = null;

    public FirefoxHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeWindow() {
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void acceptAllCookies() {

        //Accept and enable all the cookies
        WebElement acceptAllCookies = driver.findElement(By.className("col-sm-5"));
        WebElement enableAllCookies = driver.findElement(By.className("col-md-6"));
        acceptAllCookies.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        enableAllCookies.click();
    }

    public void testResearchAndEducation() {

        WebElement researchAndEducation = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[4]"));
        researchAndEducation.click();
        validateFieldsAreDisplayed();
    }

    private void validateFieldsAreDisplayed() {
        WebElement research = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[4]/div/div/div[3]/div[1]/span/i"));
        WebElement learningCenter = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[4]/div/div/div[3]/div[2]/span/i"));
        WebElement tools = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/li[4]/div/div/div[3]/div[3]/span/i"));

        Assert.assertTrue(research.isDisplayed() && learningCenter.isDisplayed() && tools.isDisplayed());
    }
}


