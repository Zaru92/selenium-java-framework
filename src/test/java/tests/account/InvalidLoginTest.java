package tests.account;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AccountLoginPage;
import testdata.factory.CredentialsFactory;

@Epic("AutomationTestStore")
@Feature("Account")
public class InvalidLoginTest extends BaseTest {

    @Test
    @Story("Invalid login shows error")
    @Severity(SeverityLevel.CRITICAL)
    void invalidLoginTest() {

        var creds = CredentialsFactory.invalid();

        var form = new AccountLoginPage(driver())
                .open(baseUrl())
                .typeLogin(creds.username())
                .typePassword(creds.password())
                .submit();


        Assertions.assertThat(form.alertText()).contains("Error: Incorrect login or password provided");
    }

}
