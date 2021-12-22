package Tests;

import Pages.MainPage;
import Utils.JsCod;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UsabilityTest extends TestRunner {

    @Test()
    public void switchLanguage() {
        MainPage basePage = loadApplication();
        basePage.changeLanguage();
        String URL = basePage.getUrl();
        Assert.assertEquals(URL,"https://www.citrus.ua/");

    }

    @Test()
    public void testScrollerPage(){
        MainPage basePage = loadApplication();
        JsCod.scrollDown();
        basePage.clickOnScrollButton();
    }
}
