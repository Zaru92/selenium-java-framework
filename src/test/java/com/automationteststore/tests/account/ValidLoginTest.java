package com.automationteststore.tests.account;

import com.automationteststore.core.BaseTest;
import com.automationteststore.pages.AccountLoginPage;
import com.automationteststore.testdata.factory.CredentialsFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@Epic("AutomationTestStore")
@Feature("Account")
public class ValidLoginTest extends BaseTest {

    private static final By ACCOUNT_NAME = By.cssSelector(".subtext");

    @Test
    @Story("Valid user can log in successfully")
    @Severity(SeverityLevel.CRITICAL)
    void validLogin() {

        var creds = CredentialsFactory.validUser();

        new AccountLoginPage(driver())
                .open(baseUrl())
                .typeLogin(creds.username())
                .typePassword(creds.password())
                .submit();

        waits.visible(ACCOUNT_NAME);

        Assertions.assertThat(driver().findElement(ACCOUNT_NAME).getText())
                .isEqualTo("Test");
    }

}
