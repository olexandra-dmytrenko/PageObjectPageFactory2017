package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by olexandra on 6/12/17.
 */
public class Waiters {

    public static final int WAIT_60 = 60;
    public static final int WAIT_10 = 10;

    public static void waitForUrl(WebDriver driver, String url, int maxTimeSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeSeconds);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void waitImplicit(WebDriver driver, int time, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }
}
