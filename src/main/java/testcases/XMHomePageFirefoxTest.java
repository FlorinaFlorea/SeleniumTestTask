package testcases;

import base.InitiateFirefoxDriver;
import org.testng.annotations.Test;
import webAutomationPages.EconomicCalendarPage;
import webAutomationPages.FirefoxHomePage;

public class XMHomePageFirefoxTest extends InitiateFirefoxDriver {

    @Test
    public void researchAndEducationTest() {

        FirefoxHomePage firefoxHomePage = new FirefoxHomePage(driver);
        firefoxHomePage.maximizeWindow();
        firefoxHomePage.acceptAllCookies();
        firefoxHomePage.testResearchAndEducation();

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
