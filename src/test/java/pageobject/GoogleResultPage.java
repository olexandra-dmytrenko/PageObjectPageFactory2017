package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Waiters;

import static util.Waiters.WAIT_60;

public class GoogleResultPage extends Page {

    public static final String URL_AUTOPRACTICE = "http://automationpractice.com/index.php";

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public void redirectToLinkByText(String linkText) {
        WebElement autoSite = driver.findElement(By.linkText(linkText));
        autoSite.click();
        Waiters.waitForUrl(driver, URL_AUTOPRACTICE, WAIT_60);
    }
}