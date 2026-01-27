package tests.cart;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CartPage;
import pages.HomePage;

@Epic("AutomationTestStore")
@Feature("Cart")
public class DeleteItemTest extends BaseTest {

    private static final By REMOVE_BUTTON = By.cssSelector(".btn.btn-sm.btn-default");


    @Test
    @Story("Remove product from Cart")
    @Severity(SeverityLevel.NORMAL)
    void deleteItemFromCart() {
        new HomePage(driver())
                .open(baseUrl())
                .addFirstProductToCart()
                .clickHeaderLink("[data-id=\"menu_cart\"]");

        waits.urlContains("checkout/cart");

        new CartPage(driver()).clickRemoveButton(".btn.btn-sm.btn-default");

        By contentPanel = By.cssSelector(".contentpanel");

        waits.visible(contentPanel);

        Assertions.assertThat(driver().findElement(By.cssSelector(".contentpanel")).getText()).contains("Your shopping cart is empty!");
    }

}
