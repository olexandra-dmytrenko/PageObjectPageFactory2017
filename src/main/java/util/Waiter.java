package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiter {

    public static final int TIME_10 = 10;
    public static final int TIME_60 = 60;

    public static void implicitWait(WebDriver driver, int time, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    public static void waitForUrl(WebDriver driver, int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
