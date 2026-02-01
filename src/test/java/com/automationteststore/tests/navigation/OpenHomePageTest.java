package com.automationteststore.tests.navigation;

import com.automationteststore.core.BaseTest;
import com.automationteststore.pages.HomePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Epic("AutomationTestStore")
@Feature("Navigation")
public class OpenHomePageTest extends BaseTest {

    @Test
    @Story("Open Home Page")
    @Severity(SeverityLevel.CRITICAL)
    void openHomePage() {
        new HomePage(driver())
                .open(baseUrl());

        Assertions.assertThat(driver().getCurrentUrl())
                .contains("automationteststore.com");
    }

}
