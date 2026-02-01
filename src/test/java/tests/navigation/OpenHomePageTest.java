package tests.navigation;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.HomePage;
import testdata.provider.EnvironmentDataProvider;

@Epic("AutomationTestStore")
@Feature("Navigation")
public class OpenHomePageTest extends BaseTest {


    @Test
    @Story("Open Home Page")
    @Severity(SeverityLevel.CRITICAL)
    void openHomePage(){

        new HomePage(driver()).open(baseUrl());

        Assertions.assertThat(driver().getCurrentUrl())
                .contains("automationteststore.com");
    }

}
