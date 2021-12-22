package Tests;


import Browser.BrowserFactory;
import Browser.BrowserСhoice;
import Pages.MainPage;
import org.testng.annotations.AfterMethod;



public class TestRunner {
    final static String baseUrl = "https://www.citrus.ua/";

    public static MainPage loadApplication(){
        BrowserСhoice.setDriver(BrowserFactory.CHROME_DRIVER);
        BrowserСhoice.getDriver().get(baseUrl);

        return  new MainPage();
    }
    @AfterMethod(alwaysRun = true )
    public void tearDown(){
        BrowserСhoice.getDriver().manage().deleteAllCookies();
        BrowserСhoice.closeBrowser();

    }



}
