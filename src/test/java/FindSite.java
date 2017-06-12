import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.GoogleResultPage;
import pageobject.GoogleSearchPage;

import static org.junit.Assert.assertEquals;
import static pageobject.GoogleResultPage.URL_AUTOPRACTICE;

/**
 * Created by olexandra on 6/11/17.
 */
public class FindSite {

    private WebDriver driver;

    @Before
    public void startDriver() {
        driver = new FirefoxDriver();

    }

    @Test
    public void findSitePage() throws InterruptedException {
        //GIVEN
//        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
//        GoogleResultPage resultPage = searchPage.search("automationpractice");
        GoogleResultPage resultPage = PageFactory.initElements(driver, GoogleSearchPage.class)
                .open()
                .search("automationpractice");
        //WHEN
        resultPage.redirectToLinkByText("Automation Practice");
        //THEN
        assertEquals(URL_AUTOPRACTICE, driver.getCurrentUrl());
    }

    @After
    public void stutDownDriver() {
        driver.close();
    }
}
