package tests.account;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.AccountLoginPage;
import testdata.factory.CredentialsFactory;

@Epic("AutomationTestStore")
@Feature("Account")
public class ValidLoginTest extends BaseTest {

    private static final By ACCOUNT_NAME = By.cssSelector(".subtext");

    @Test
    @Story("Valid user can log in successfully")
    @Severity(SeverityLevel.CRITICAL)
    void ValidLogin() {


        var creds = CredentialsFactory.validUser();

        new AccountLoginPage(driver())
                .open(baseUrl())
                .typeLogin(creds.username())
                .typePassword(creds.password())
                .submit();

        waits.visible(ACCOUNT_NAME);

        Assertions.assertThat(driver().findElement(ACCOUNT_NAME).getText()).isEqualTo("Test");
    }

}
