package Tests;


import Browser.BrowserСhoice;
import Pages.BasePage;


public class TestRunner {
    final static String baseUrl = "https://www.citrus.ua/";






    public static BasePage loadApplication(){
        BrowserСhoice.getDriver().get(baseUrl);

        return  new BasePage();
    }
}
