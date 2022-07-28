package testcases;

import base.InitiateSafariDriver;
import org.testng.annotations.Test;
import webAutomationPages.EconomicCalendarPage;
import webAutomationPages.SafariHomePage;

public class XMHomePageSafariTest extends InitiateSafariDriver {

    @Test
    public void researchAndEducationTest() {

        SafariHomePage safariHomePage = new SafariHomePage(driver);
        safariHomePage.maximizeWindow();
        safariHomePage.acceptAllCookies();
        safariHomePage.testResearchAndEducation();

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
