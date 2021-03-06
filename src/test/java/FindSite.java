import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/11/17.
 * Download driver from here: https://github.com/mozilla/geckodriver/releases
 */
public class FindSite {
    private WebDriver driver;

    @Before
    public void startDriver() {
        driver = new FirefoxDriver();
    }

    @Test
    public void findSitePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://google.com.ua/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("automationpractice");
        searchField.submit();

        WebElement autoSite = driver.findElement(By.linkText("Automation Practice"));
        autoSite.click();

        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php"));
        assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
    }

    @After
    public void stutDownDriver() {
        driver.close();
    }
}
