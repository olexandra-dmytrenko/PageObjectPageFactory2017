package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

import static utils.Waiters.WAIT_60;

/**
 * Created by olexandra on 6/12/17.
 */
public class GoogleResultPage extends Page {

    private static final By BY_LINK_TEXT_AUTO_PRACTICE = By.linkText("Automation Practice");
    public static final String URL_AUTOPRACTICE = "http://automationpractice.com/index.php";

    GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public void redirectToLinkByText(String linkText) {
        WebElement autoSite = driver.findElement(By.linkText(linkText));
        autoSite.click();
        Waiters.waitForUrl(driver, URL_AUTOPRACTICE, WAIT_60);
    }

    public void redirectToAutoPracticeSite() {
        WebElement autoSite = driver.findElement(BY_LINK_TEXT_AUTO_PRACTICE);
        autoSite.click();
        Waiters.waitForUrl(driver, URL_AUTOPRACTICE, WAIT_60);
    }
}
