package Tests;

import Browser.BrowserСhoice;
import Pages.MainPage;
import Pages.ProductPage;
import Utils.JsCod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class UsabilityTest extends TestRunner  {



    @Test()
    public void switchLanguage() {
        MainPage mainPage = loadApplication();
        mainPage.changeLanguage();
        String URL = mainPage.getUrlName();
        Assert.assertEquals(URL,"https://www.citrus.ua/");

    }

    @Test()
    public void testScrollerPage()  {
        MainPage mainPage = loadApplication();
        var firstPosition =   mainPage.getPoint();
        JsCod.scrollDown();
        mainPage.clickOnScrollButton();
        var secondPosition =  mainPage.getPoint();
        Assert.assertNotEquals(firstPosition.getY(),secondPosition.getY());
    }


    @Test()
    public void scaleProductImageTest(){
        MainPage mainPage = loadApplication();
        ProductPage productPage = mainPage.searchProductInTopSearch("samsung");
        var  productBeforeScale =  productPage.returnFirstProduct().getSize();
        mainPage.setMaxWindowResolution();
        var productAfterScale = productPage.returnFirstProduct().getText();
        Assert.assertNotEquals(productBeforeScale,productAfterScale);





    }


}
