package webAutomationPages;

import base.InitiateSafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

//The home page displayed for the user when navigating to the URL
public class SafariHomePage extends InitiateSafariDriver {

    WebDriver driver = null;

    public SafariHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void acceptAllCookies() {

        //Accept and enable all the cookies
        WebElement acceptAllCookies = (WebElement) new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("col-sm-5")));
        acceptAllCookies.click();
        WebElement enableAllCookies = (WebElement) new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("col-md-6")));
        enableAllCookies.click();
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


