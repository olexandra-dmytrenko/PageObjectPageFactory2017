package three_pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import two_pageobject.GoogleResultPage;

public class GoogleSearchPageFactory extends Page {
    private static final String LINK_GOOGLE = "http://google.com.ua/";

    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleSearchPageFactory() {
        super();
        open();
    }

    public GoogleSearchPageFactory(WebDriver driver) {
        super(driver);
        open();
    }

    private void open() {
        driver.get(LINK_GOOGLE);
    }

    public GoogleResultPageFactory search(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        return PageFactory.initElements(driver, GoogleResultPageFactory.class);
    }
}
