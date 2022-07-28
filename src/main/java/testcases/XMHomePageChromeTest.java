package testcases;

import base.InitiateChromeDriver;
import org.testng.annotations.Test;
import webAutomationPages.EconomicCalendarPage;
import webAutomationPages.ChromeHomePage;

public class XMHomePageChromeTest extends InitiateChromeDriver {

    @Test
    public void researchAndEducationTest() {

        ChromeHomePage chromeHomePage = new ChromeHomePage(driver);
        chromeHomePage.maximizeWindow();
        chromeHomePage.acceptAllCookies();
        chromeHomePage.testResearchAndEducation();

        //Click economic calendar
        EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage();
        economicCalendarPage.clickEconomicCalendar(driver);

        clickAndValidateDates(economicCalendarPage);

        //Click here in the disclaimer
        economicCalendarPage.clickHereInDisclaimer(driver);
    }

    private void clickAndValidateDates(EconomicCalendarPage economicCalendarPage) {
        //Click yesterday and check the date
        economicCalendarPage.clickYesterday(driver);
        economicCalendarPage.validateDisplayedDate(driver);

        //Click today and check the date
        economicCalendarPage.clickToday(driver);
        economicCalendarPage.validateDisplayedDate(driver);

        //Click tomorrow and check the date
        economicCalendarPage.clickTomorrow(driver);
        economicCalendarPage.validateDisplayedDate(driver);
    }
}
