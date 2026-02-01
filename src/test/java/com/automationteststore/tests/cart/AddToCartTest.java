package com.automationteststore.tests.cart;

import com.automationteststore.core.BaseTest;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.HomePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("AutomationTestStore")
@Feature("Cart")
public class AddToCartTest extends BaseTest {

    @Test
    @Story("Add product to Cart")
    @Severity(SeverityLevel.CRITICAL)
    void addToCart() {

        new HomePage(driver())
                .open(baseUrl())
                .addFirstProductToCart()
                .openCart();

        CartPage cartPage = new CartPage(driver()).waitUntilLoaded();

        Assertions.assertThat(cartPage.isCheckoutButtonVisible()).isTrue();
    }

}
