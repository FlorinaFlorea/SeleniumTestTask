package webAutomationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

//The displayed page after clicking the economic calendar button
public class EconomicCalendarPage {

    public void clickEconomicCalendar(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='https://www.xm.com/research/economicCalendar']")));
        WebElement economicCalendar = driver.findElement(By.cssSelector("a[href*='https://www.xm.com/research/economicCalendar']"));
        economicCalendar.click();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void clickYesterday(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeFrame_yesterday")));
        WebElement yesterday = driver.findElement(By.id("timeFrame_yesterday"));
        yesterday.click();
    }

    public void clickToday(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeFrame_today")));

        WebElement today = driver.findElement(By.id("timeFrame_today"));
        today.click();
    }

    public void clickTomorrow(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeFrame_tomorrow")));

        WebElement tomorrow = driver.findElement(By.id("timeFrame_tomorrow"));
        tomorrow.click();
    }

    public void validateDisplayedDate(WebDriver driver) {
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDateTime time = LocalDateTime.now();
        String expectedDate = dtf.format(time);
        System.out.println("Expected date: " + expectedDate);
        WebElement displayedDate = driver.findElement(By.className("theDay"));
        System.out.println("Displayed date: " + displayedDate);
        Assert.assertEquals(displayedDate.getText(), expectedDate);
    }

    public void clickHereInDisclaimer(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2000)");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement here = driver.findElement(By.cssSelector("a[href*='/research/risk_warning']"));
        here.click();
    }
}
