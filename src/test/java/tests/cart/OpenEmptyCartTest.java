package tests.cart;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.HomePage;

@Epic("AutomationTestStore")
@Feature("Cart")
public class OpenEmptyCartTest extends BaseTest {


    @Test
    @Story("Open Empty Cart")
    @Severity(SeverityLevel.CRITICAL)
    void addToCart() {
        new HomePage(driver())
                .open(baseUrl())
                .clickHeaderLink("[data-id=\"menu_cart\"]");

        waits.urlContains("checkout/cart");

        Assertions.assertThat(driver().findElement(By.cssSelector(".contentpanel")).getText()).contains("Your shopping cart is empty!");

    }

}
