package Utils;

import Browser.BrowserСhoice;
import org.openqa.selenium.JavascriptExecutor;

public class JsCod {

    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) BrowserСhoice.getDriver();
        js.executeScript("window.scrollBy(0,1500)");
    }
}
