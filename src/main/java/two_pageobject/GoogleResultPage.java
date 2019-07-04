package two_pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Waiter;

import static util.Waiter.waitForUrl;

public class GoogleResultPage {

    public static final String URL_AUTO_PRACTICE = "http://automationpractice.com/index.php";
    WebDriver driver;

    @FindBy(partialLinkText = "Automation Practice")
    WebElement autoSite;


    public GoogleResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrlByName(String urlName, String url) {
        autoSite.click();
        waitForUrl(driver, Waiter.TIME_60, URL_AUTO_PRACTICE);
    }
}
