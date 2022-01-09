package Pages;


import Browser.BrowserСhoice;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface BasePage {

    default  Dimension getWindowResolution(){
       WebDriver driver  =  BrowserСhoice.getDriver();
       return driver.manage().window().getSize();

    }

    default   String getUrlName(){
        return BrowserСhoice.getDriver().getCurrentUrl();
    }


    default Point getElementPoint(WebElement element){
        WebDriver driver  =  BrowserСhoice.getDriver();
        return element.getLocation();
    }


    default void  setMaxWindowResolution(){
        BrowserСhoice.getDriver().manage().window().maximize();
    }

    default  void setWindowResolution(int h , int w){
         Dimension dimension = new Dimension(h,w);
         BrowserСhoice.getDriver().manage().window().setSize(dimension);
    }

    default  void  goForward(){
        BrowserСhoice.getDriver().navigate().forward();
    }

    default  void  goBack(){
        BrowserСhoice.getDriver().navigate().back();
    }

    default  void  navigateTo(String url){
        BrowserСhoice.getDriver().navigate().to(url);

    }
}

