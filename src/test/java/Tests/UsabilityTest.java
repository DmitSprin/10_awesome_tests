package Tests;

import Pages.MainPage;
import Utils.JsCod;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UsabilityTest extends TestRunner {

    @Test()
    @Description("this test check the ability to change the language")
    @Severity(SeverityLevel.MINOR)
    public void switchLanguage() {
        MainPage basePage = loadApplication();
        basePage.changeLanguage();
        String URL = basePage.getUrl();
        Assert.assertEquals(URL,"https://www.citrus.ua/");

    }

    @Test()
    @Description("this test check the ability to use interactive elements of the site")
    @Severity(SeverityLevel.TRIVIAL)
    public void testScrollerPage(){
        MainPage basePage = loadApplication();
        JsCod.scrollDown();
        basePage.clickOnScrollButton();
    }


}
