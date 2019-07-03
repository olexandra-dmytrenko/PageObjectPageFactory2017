package two_pageobject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/11/17.
 */
public class FindSite {

    @Test
    public void findSitePage() {
        //GIVEN
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        GoogleResultPage results = googleSearchPage.search("automationpractice");

        //WHEN
        results.getPartialLinkUrl("Automation Practice",
                "http://automationpractice.com/index.php");

        //THEN
        assertEquals("http://automationpractice.com/index.php", googleSearchPage.getDriver().getCurrentUrl());
    }


//    @After
//    public void stutDownDriver() {
//        driver.close();
//    }
}
