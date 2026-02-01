package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSuccessPage extends BasePage {

    private static final By CONTINUE_BUTTON = By.cssSelector("[title=\"Continue\"]");
    private static final By SUCCESS_MESSAGE = By.cssSelector(".maintext");

    public CheckoutSuccessPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutSuccessPage continueFromSuccessPage() {
        click(CONTINUE_BUTTON);

        return this;
    }

    public CheckoutSuccessPage waitUntilLoaded() {
        waits.urlContains("checkout/success");
        return this;
    }

    public String successMessageText() {
        return textOf(SUCCESS_MESSAGE);
    }
}
