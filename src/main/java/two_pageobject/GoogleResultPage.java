package two_pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleResultPage extends Page{

    public GoogleResultPage(){
        super();
    }

    public void getPartialLinkUrl(String text, String url) {
        WebElement autoSite = driver.findElement(By.partialLinkText(text));
        autoSite.click();
        waiter.waitForUrl(url);
    }
}
