package tests.account;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;
import testdata.factory.AddressFactory;
import testdata.factory.CredentialsFactory;
import testdata.factory.UserFactory;
import testdata.store.CreatedAccountsStore;

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
