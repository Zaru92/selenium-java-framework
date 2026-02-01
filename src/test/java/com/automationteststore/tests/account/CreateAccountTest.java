package com.automationteststore.tests.account;

import com.automationteststore.core.BaseTest;
import com.automationteststore.pages.CreateAccountPage;
import com.automationteststore.testdata.factory.AddressFactory;
import com.automationteststore.testdata.factory.CredentialsFactory;
import com.automationteststore.testdata.factory.UserFactory;
import com.automationteststore.testdata.store.CreatedAccountsStore;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("AutomationTestStore")
@Feature("Account")
public class CreateAccountTest extends BaseTest {

    @Test
    @Story("User creates an account successfully")
    @Severity(SeverityLevel.CRITICAL)
    void createAccountSuccessfully() {

        var creds = CredentialsFactory.randomUser();
        var address = AddressFactory.randomValidAddress();
        var user = UserFactory.randomValidUser();
        String region = "Aberdeen";

        var form = new CreateAccountPage(driver())
                .open(baseUrl())
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

        Assertions.assertThat(form.successMessageText())
                .isEqualTo("YOUR ACCOUNT HAS BEEN CREATED!");

        CreatedAccountsStore.save(creds.username(), creds.password());

        Allure.addAttachment("Created account username", creds.username());
    }

}
