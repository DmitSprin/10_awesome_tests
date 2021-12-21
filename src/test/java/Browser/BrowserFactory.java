package Browser;

import org.openqa.selenium.WebDriver;

public enum BrowserFactory {
    DEFAULT_BROWSER(new ChromeDriverBrowser()),
    CHROME_DRIVER(new ChromeDriverBrowser()),
    FIREFOX_DRIVER(new FirefoxBrowser()),
    EDGE_BROWSER(new EgeBrowser());

    BrowsersList list;

    BrowserFactory(BrowsersList list) {
      this.list = list;
    }
    WebDriver getDriver(){
        return list.getBrowser();
    }


}



