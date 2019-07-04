package one_goodoldtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import two_pageobject.GoogleResultPage;
import two_pageobject.GoogleSearchPage;
import util.Waiter;

import static org.junit.Assert.assertEquals;
import static two_pageobject.GoogleResultPage.URL_AUTO_PRACTICE;

/**
 * Created by olexandra on 6/11/17.
 */
public class FindSite {

    private WebDriver driver;

    @Before
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    //    System.setProperty("webdriver.chrome.driver", "chromedriver_mac64");
        driver = new ChromeDriver();
    }

    @Test
    public void findSitePage() throws InterruptedException {
        //Given
        GoogleSearchPage searchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
        GoogleResultPage resultPage = searchPage.search("automationpractice");

        //WHEN
        resultPage.openUrlByName("Automation Practice", URL_AUTO_PRACTICE);

        //THEN
        assertEquals(URL_AUTO_PRACTICE, driver.getCurrentUrl());
    }

    @After
    public void stutDownDriver() {
        driver.close();
    }
}
