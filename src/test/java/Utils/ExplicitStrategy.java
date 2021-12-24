package Utils;

import Browser.BrowserСhoice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitStrategy {

 private static  WebDriver driver = BrowserСhoice.getDriver();
 static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

   public void waitForElement(WebElement element)  {
      wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElements(List<WebElement> element)  {
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
}
