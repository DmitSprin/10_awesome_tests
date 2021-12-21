package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface BrowsersList {
    public WebDriver getBrowser();

}

    class ChromeDriverBrowser implements BrowsersList{

        @Override
        public WebDriver getBrowser() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }

    class FirefoxBrowser implements BrowsersList{

        @Override
        public WebDriver getBrowser() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }

    class  EgeBrowser implements BrowsersList{

        @Override
        public WebDriver getBrowser() {
            WebDriverManager.edgedriver().setup();
            return  new EdgeDriver();
        }
    }

