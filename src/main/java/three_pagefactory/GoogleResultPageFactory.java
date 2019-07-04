package three_pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultPageFactory extends Page {

    public GoogleResultPageFactory(WebDriver driver){
        super(driver);
    }

    public void getPartialLinkUrl(String text, String url) {
        WebElement autoSite = driver.findElement(By.partialLinkText(text));
        autoSite.click();
        waiter.waitForUrl(url);
    }
}
