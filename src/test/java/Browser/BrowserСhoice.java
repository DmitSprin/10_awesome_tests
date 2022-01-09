package Browser;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserСhoice {

    private static Map<Long, WebDriver> drivers = new HashMap<>();


    public static WebDriver getDriver(){

        if(drivers.get(Thread.currentThread().getId()) == null){
            setDriver(BrowserFactory.DEFAULT_BROWSER);

        }
        WebDriver driver = drivers.get(Thread.currentThread().getId());
         return driver;
    }


    public static void setDriver(BrowserFactory Driver){
        drivers.put(Thread.currentThread().getId(), Driver.getDriver());

    }

    public static void getUrl(String url) {
        getDriver().get(url);
    }

    public static void closeBrowser(){

        for (Map.Entry<Long , WebDriver> entry : drivers.entrySet()){
           if( entry.getKey() != null){
               entry.getValue().manage().deleteAllCookies();
               entry.getValue().quit();
           }
        }
    }



}
