package com.automationteststore.tests.checkout;

import com.automationteststore.core.BaseTest;
import com.automationteststore.pages.CartPage;
import com.automationteststore.pages.CheckoutConfirmationPage;
import com.automationteststore.pages.CheckoutOptionsPage;
import com.automationteststore.pages.CheckoutSuccessPage;
import com.automationteststore.pages.GuestCheckoutFormPage;
import com.automationteststore.pages.HomePage;
import com.automationteststore.testdata.factory.AddressFactory;
import com.automationteststore.testdata.factory.UserFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("AutomationTestStore")
@Feature("Checkout")
public class GuestCheckoutTest extends BaseTest {

    @Test
    @Story("Guest checkout completes successfully")
    @Severity(SeverityLevel.CRITICAL)
    void finalizeCheckoutSuccessfully() {

        var address = AddressFactory.randomValidAddress();
        var user = UserFactory.randomValidUser();
        String region = "Aberdeen";

        new HomePage(driver())
                .open(baseUrl())
                .addFirstProductToCart()
                .openCart();

        new CartPage(driver())
                .waitUntilLoaded()
                .clickCheckoutButton();

        new CheckoutOptionsPage(driver())
                .waitUntilLoaded()
                .continueAsAGuest();

        new GuestCheckoutFormPage(driver())
                .waitUntilLoaded()
                .typeFirstName(user.firstName())
                .typeLastName(user.lastName())
                .typeEmailAddress(user.email())
                .typePhoneNumber(user.phone())
                .typeAddress1(address.addressLine1())
                .typeCity(address.city())
                .selectRegion(region)
                .typeZipCode(address.zipCode())
                .submitForm();

        new CheckoutConfirmationPage(driver())
                .waitUntilLoadedAsAGuest()
                .confirmOrder();

        CheckoutSuccessPage successPage = new CheckoutSuccessPage(driver())
                .waitUntilLoaded();

        Assertions.assertThat(successPage.successMessageText())
                .contains("YOUR ORDER HAS BEEN PROCESSED!");

    }
}
