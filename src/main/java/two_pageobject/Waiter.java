package two_pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiter extends Page {

    public Waiter(){
        super();
    }

    public Waiter(WebDriver driver) {

    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
