package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static util.Waiters.waitImplicit;

public class GoogleSearchPage extends Page {
    public static final String GOOGLE_URL = "http://google.com.ua/";

    private static final By BY_SEARCH_FIELD_ID = By.id("lst-ib");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        open();
    }

    public void open() {
        driver.get(GOOGLE_URL);
        waitImplicit(driver, 10, TimeUnit.SECONDS);
    }

    public GoogleResultPage search(String text) {
        WebElement searchField = driver.findElement(BY_SEARCH_FIELD_ID);
        searchField.sendKeys(text);
        searchField.submit();
        return new GoogleResultPage(driver);
    }
}