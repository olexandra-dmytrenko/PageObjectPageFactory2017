package two_pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends Page{
    private static final String LINK_GOOGLE = "http://google.com.ua/";

    public GoogleSearchPage() {
        super();
        open();
    }

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        open();
    }

    private void open(){
        driver.get(LINK_GOOGLE);
    }

    public GoogleResultPage search(String text) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(text);
        searchField.submit();
        return new GoogleResultPage(driver);
    }
}
