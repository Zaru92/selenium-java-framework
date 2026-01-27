package tests.checkout;


import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.*;
import testdata.factory.CredentialsFactory;

@Epic("AutomationTestStore")
@Feature("Checkout")
public class CheckoutLoginDuringFlowTest extends BaseTest {

    @Test
    @Story("Login during checkout completes successfully")
    @Severity(SeverityLevel.CRITICAL)
    void finalizeCheckoutSuccessfully() {

        var creds = CredentialsFactory.validUser();

        final By successMessage = By.cssSelector(".maintext");

        new HomePage(driver())
                .open(baseUrl())
                .addFirstProductToCart()
                .clickHeaderLink("[data-id=\"menu_cart\"]");

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

        new CheckoutSuccessPage(driver()).waitUntilLoaded();

        String successMessageText = driver().findElement(successMessage).getText();

        Assertions.assertThat(successMessageText).contains("YOUR ORDER HAS BEEN PROCESSED!");

    }
}
