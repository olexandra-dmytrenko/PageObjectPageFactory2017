package two_pageobject;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {
    static WebDriver driver;
    static Waiter waiter;

    public Page() {
        //        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "chromedriver_mac64");
        if (this.driver == null) {
            driver = new ChromeDriver();
            waiter = new Waiter(driver);
        }
    }

    public Page(WebDriver driver){
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void stutDownDriver() {
        driver.close();
    }
}
