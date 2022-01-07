package Utils;

import Browser.BrowserСhoice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsCod {

    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) BrowserСhoice.getDriver();
        js.executeScript("window.scrollBy(0,1500)");
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(BrowserСhoice.getDriver(), timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
