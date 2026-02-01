package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By CATEGORY_HEADER = By.cssSelector(".maintext");
    private static final By MAIN_CONTAINER = By.id("maincontainer");
    private static final By CART_COUNTER = By.cssSelector(".block_7 a > .label-orange");
    private static final By CART_BUTTON = By.cssSelector("[data-id=\"menu_cart\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String baseUrl) {
        for (int i = 0; i < 2; i++) {
            driver.get(baseUrl);
            try {
                waits.documentReady();
                waits.visible(MAIN_CONTAINER);
                return this;
            } catch (Exception e) {
                if (i == 1) throw e;
            }
        }
        return this;
    }

    public HomePage clickCategory(String cssSelector) {
        By categoryLink = By.cssSelector(cssSelector);

        click(categoryLink);

        waits.visible(CATEGORY_HEADER);

        return this;
    }

    public HomePage clickHeaderLink(String cssSelector) {
        By headerCategoryLink = By.cssSelector(cssSelector);

        click(headerCategoryLink);

        return this;
    }

    public HomePage addFirstProductToCart() {
        By firstProductAddToCartButton = By.cssSelector(".productcart");

        click(firstProductAddToCartButton);
        waits.textToBe(CART_COUNTER, "1");
        return this;
    }

    public HomePage openCart() {
        click(CART_BUTTON);
        return this;
    }

    public String categoryHeaderText() {
        return textOf(CATEGORY_HEADER).trim();
    }

}
