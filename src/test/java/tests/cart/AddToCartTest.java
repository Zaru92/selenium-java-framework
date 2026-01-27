package tests.cart;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.HomePage;

@Epic("AutomationTestStore")
@Feature("Cart")
public class AddToCartTest extends BaseTest {

    private static final By CART_BUTTON = By.cssSelector("[data-id=\"menu_cart\"]");

    @Test
    @Story("Add product to Cart")
    @Severity(SeverityLevel.CRITICAL)
    void addToCart() {
        new HomePage(driver())
                .open(baseUrl())
                .addFirstProductToCart();


        driver().findElement(CART_BUTTON).click();

        waits.urlContains("checkout/cart");

        Assertions.assertThat(driver().findElement(By.cssSelector("#cart_checkout1")).isDisplayed())
                .isTrue();
    }

}
