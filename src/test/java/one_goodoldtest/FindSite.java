package one_goodoldtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/11/17.
 */
public class FindSite {
    private WebDriver driver;

    @Before
    public void startDriver() {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "chromedriver_mac64");
        driver = new ChromeDriver();
    }

    @Test
    public void findSitePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get("http://google.com.ua/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("automationpractice");
        searchField.submit();

        WebElement autoSite = driver.findElement(By.partialLinkText("Automation Practice"));
        autoSite.click();

        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php"));
        assertEquals("http://automationpractice.com/index.php", driver.getCurrentUrl());
    }

    @After
    public void stutDownDriver() {
        driver.close();
    }
}
