package two_pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import util.Waiter;

public class GoogleSearchPage {
    private static final String GOOGLE_LINK = "http://google.com.ua/";
    WebDriver driver;

    @CacheLookup
    @FindBy(name = "q")
    WebElement searchField;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        open();
    }

    private void open() {
        driver.get(GOOGLE_LINK);
        Waiter.implicitWait(driver, Waiter.TIME_10, TimeUnit.SECONDS);
    }

    public GoogleResultPage search(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        return PageFactory.initElements(driver, GoogleResultPage.class);
    }
}
