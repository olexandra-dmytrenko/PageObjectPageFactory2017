package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {

    public static final int WAIT_10 = 10;
    public static final int WAIT_60 = 60;

    public static void waitImplicit(WebDriver driver, int amountOfTime, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(amountOfTime, timeUnit);
    }

    public static void waitForUrl(WebDriver driver, String automation_site_url, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.urlToBe(automation_site_url));
    }
}