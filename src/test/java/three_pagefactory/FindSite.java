package three_pagefactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import two_pageobject.GoogleResultPage;
import two_pageobject.GoogleSearchPage;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/11/17.
 */
public class FindSite {

    private WebDriver driver;

    @Before
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "chromedriver_mac64");
        driver = new ChromeDriver();
    }

    @Test
    public void findSitePage() {
        //GIVEN
        GoogleSearchPageFactory googleSearchPage = PageFactory.initElements(driver, GoogleSearchPageFactory.class);
        GoogleResultPageFactory results = googleSearchPage.search("automationpractice");

        //WHEN
        results.getPartialLinkUrl("Automation Practice",
                "http://automationpractice.com/index.php");

        //THEN
        assertEquals("http://automationpractice.com/index.php", googleSearchPage.getDriver().getCurrentUrl());
    }

    @Test
    public void findSitePageChainOfResponsibility() {
        //GIVEN
        GoogleSearchPageFactory googleSearchPage = PageFactory.initElements(driver, GoogleSearchPageFactory.class);
        GoogleResultPageFactory results = googleSearchPage.search("automationpractice");

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
