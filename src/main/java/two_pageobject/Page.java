package two_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {
    final WebDriver driver;
    final Waiter waiter;

    public Page() {
        //        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "chromedriver_mac64");

        driver = new ChromeDriver();
        waiter = new Waiter(driver);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
