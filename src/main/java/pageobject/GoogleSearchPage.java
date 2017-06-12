package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static utils.Waiters.WAIT_10;
import static utils.Waiters.waitImplicit;

/**
 * Created by olexandra on 6/12/17.
 */
public class GoogleSearchPage extends Page {

    private static final String GOOGLE_URL = "http://google.com.ua/";
    @FindBy(id = "lst-ib")
    @CacheLookup
    private WebElement searchField;
//    private static final By BY_SEARCH_FIELD_ID = By.id("lst-ib");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    public GoogleSearchPage open() {
        driver.get(GOOGLE_URL);
        waitImplicit(driver, WAIT_10, TimeUnit.SECONDS);
        return this;
    }

    public GoogleResultPage search(String text) {
//        WebElement searchField = driver.findElement(BY_SEARCH_FIELD_ID);
        searchField.sendKeys(text);
        searchField.submit();
        return new GoogleResultPage(driver);
    }
}
