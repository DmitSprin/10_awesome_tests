package Browser;

import org.openqa.selenium.WebDriver;

public class BrowserСhoice {

    private static WebDriver driver = null;


    public static WebDriver getDriver(){

        if(driver == null){
            setDriver(BrowserFactory.DEFAULT_BROWSER);

        }
            return driver;
    }


    public static void setDriver(BrowserFactory Driver){

        driver = Driver.getDriver();

    }

    public static void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
