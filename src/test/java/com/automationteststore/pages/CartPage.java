package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By CHECKOUT_BUTTON = By.id("cart_checkout1");
    private static final By CONTENT_PANEL = By.cssSelector(".contentpanel");
    private static final By REMOVE_BUTTON = By.cssSelector(".btn.btn-sm.btn-default");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage waitUntilLoaded() {
        waits.urlContains("checkout/cart");
        return this;
    }

    public CartPage clickCheckoutButton() {

        click(CHECKOUT_BUTTON);

        return this;
    }

    public CartPage removeFirstItem() {
        click(REMOVE_BUTTON);
        return this;
    }

    public boolean isCheckoutButtonVisible() {
        return waits.visible(CHECKOUT_BUTTON).isDisplayed();
    }

    public String emptyCartMessage() {
        return textOf(CONTENT_PANEL);
    }
}
