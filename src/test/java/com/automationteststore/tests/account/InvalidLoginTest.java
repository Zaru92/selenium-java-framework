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

        Assertions.assertThat(form.alertText())
                .contains("Error: Incorrect login or password provided");
    }

}
