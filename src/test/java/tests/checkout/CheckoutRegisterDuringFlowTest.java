package tests.checkout;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.*;
import testdata.factory.AddressFactory;
import testdata.factory.CredentialsFactory;
import testdata.factory.UserFactory;

@Epic("AutomationTestStore")
@Feature("Checkout")
public class CheckoutRegisterDuringFlowTest extends BaseTest {

    @Test
    @Story("Registration during checkout completes successfully")
    @Severity(SeverityLevel.CRITICAL)
    void finalizeCheckoutSuccessfully() {

        final By successMessage = By.cssSelector(".maintext");

        var creds = CredentialsFactory.randomUser();
        var address = AddressFactory.randomValidAddress();
        var user = UserFactory.randomValidUser();
        String region = "Aberdeen";

        new HomePage(driver())
                .open(baseUrl())
                .addFirstProductToCart()
                .clickHeaderLink("[data-id=\"menu_cart\"]");

        new CartPage(driver())
                .waitUntilLoaded()
                .clickCheckoutButton();

        new CheckoutOptionsPage(driver())
                .waitUntilLoaded()
                .continueWithRegistration();

        new CreateAccountPage(driver())
                .waitUntilLoaded()
                .typeFirstName(user.firstName())
                .typeLastName(user.lastName())
                .typeEmailAddress(user.email())
                .typePhoneNumber(user.phone())
                .typeAddress1(address.addressLine1())
                .typeCity(address.city())
                .selectRegion(region)
                .typeZipCode(address.zipCode())
                .typeLogin(creds.username())
                .typePassword(creds.password())
                .typePasswordConfirmation(creds.password())
                .confirmPrivacyPolicy()
                .submitForm();

        new CheckoutConfirmationPage(driver())
                .waitUntilLoaded()
                .confirmOrder();

        new CheckoutSuccessPage(driver()).waitUntilLoaded();

        String successMessageText = driver().findElement(successMessage).getText();

        Assertions.assertThat(successMessageText).contains("YOUR ORDER HAS BEEN PROCESSED!");

    }
}
