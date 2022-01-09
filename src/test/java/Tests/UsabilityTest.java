package Tests;

import Pages.BasePage;
import Pages.MainPage;
import Pages.ProductPage;
import Utils.JsCod;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class UsabilityTest extends TestRunner  {



    @Test()
    public void switchLanguage() {
        MainPage mainPage = loadApplication();
        mainPage.changeLanguage();
        String URL = mainPage.getUrlName();
        Assert.assertEquals(URL,"https://www.citrus.ua/");

    }

    @Test()
    public void testScrollerPage() throws InterruptedException {
        MainPage mainPage = loadApplication();
        var firstPosition =   mainPage.getPoint();
        JsCod.scrollDown();
        mainPage.clickOnScrollButton();
        var secondPosition =  mainPage.getPoint();
        Assert.assertNotEquals(firstPosition.getY(),secondPosition.getY());
    }

}
