package Tests;

import Browser.BrowserСhoice;
import Pages.BasePage;
import Utils.JsCod;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import static Tests.TestRunner.loadApplication;

public class UsabilityTest {

    @Test()
    public void switchLanguage() {
        BasePage basePage = loadApplication();
        basePage.changeLanguage();
        String URL = basePage.getUrl();
        Assert.assertEquals(URL,"https://www.citrus.ua/");

    }

    @Test()
    public void testScrollerPage(){
        BasePage basePage = loadApplication();
        JsCod.scrollDown();
        basePage.clickOnScrollButton();
    }

    @AfterTest(alwaysRun = true )
    public void tearDown(){
        BrowserСhoice.closeBrowser();

    }
}
