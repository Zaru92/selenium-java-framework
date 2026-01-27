package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By checkoutButton = By.id("cart_checkout1");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage waitUntilLoaded() {
        waits.urlContains("checkout/cart");
        return this;
    }

    public CartPage clickRemoveButton(String cssSelector) {
        By removeButton = By.cssSelector(cssSelector);

        waits.scrollIntoView(removeButton);
        waits.safeClick(removeButton);

        return this;
    }

    public CartPage clickCheckoutButton() {

        waits.scrollIntoView(checkoutButton);
        waits.safeClick(checkoutButton);

        return this;
    }

}
