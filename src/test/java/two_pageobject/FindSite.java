package two_pageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void findSitePage() {
        //GIVEN
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        GoogleResultPage results = googleSearchPage.search("automationpractice");

        //WHEN
        results.getPartialLinkUrl("Automation Practice",
                "http://automationpractice.com/index.php");

        //THEN
        assertEquals("http://automationpractice.com/index.php", googleSearchPage.getDriver().getCurrentUrl());
    }


    @After
    public void stutDownDriver() {
        driver.close();
    }
}
