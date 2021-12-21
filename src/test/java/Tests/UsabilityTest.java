package Tests;

import Pages.BasePage;
import org.testng.Assert;
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


}
