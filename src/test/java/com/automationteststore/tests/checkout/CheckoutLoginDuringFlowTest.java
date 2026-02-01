package com.automationteststore.tests.checkout;
import com.automationteststore.core.BaseTest;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.CheckoutConfirmationPage;
import com.automationteststore.pages.CheckoutOptionsPage;
import com.automationteststore.pages.CheckoutSuccessPage;
import com.automationteststore.pages.HomePage;
import com.automationteststore.testdata.factory.CredentialsFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("AutomationTestStore")
@Feature("Checkout")
public class CheckoutLoginDuringFlowTest extends BaseTest {

    @Test
    @Story("Login during checkout completes successfully")
    @Severity(SeverityLevel.CRITICAL)
    void finalizeCheckoutSuccessfully() {

        var creds = CredentialsFactory.validUser();

        new HomePage(driver())
                .open(baseUrl())
                .addFirstProductToCart()
                .openCart();

        new CartPage(driver())
                .waitUntilLoaded()
                .clickCheckoutButton();

        new CheckoutOptionsPage(driver())
                .waitUntilLoaded()
                .typeLogin(creds.username())
                .typePassword(creds.password())
                .submitLogin();

        new CheckoutConfirmationPage(driver())
                .waitUntilLoaded()
                .confirmOrder();

        CheckoutSuccessPage successPage = new CheckoutSuccessPage(driver())
                .waitUntilLoaded();

        Assertions.assertThat(successPage.successMessageText())
                .contains("YOUR ORDER HAS BEEN PROCESSED!");

    }
}
