package tests.navigation;

import core.BaseTest;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;

import java.util.stream.Stream;

@Epic("AutomationTestStore")
@Feature("Navigation")
@Execution(ExecutionMode.SAME_THREAD)
public class HeaderNavigationTest extends BaseTest {

    record HeaderCategoryCase(String story, String cssToClick, String urlContains) {
        @Override
        public String toString() {
            return story;
        }
    }

    static Stream<HeaderCategoryCase> headerCategoryCases() {
        return Stream.of(new HeaderCategoryCase("Navigate to Account Page", "#customer_menu_top", "account"), new HeaderCategoryCase("Navigate to Specials Page", "[data-id=\"menu_specials\"]", "special"), new HeaderCategoryCase("Navigate to Cart Page", "[data-id=\"menu_cart\"]", "cart"));
    }

    @ParameterizedTest(name = "{index} => {0}")
    @MethodSource("headerCategoryCases")
    @Severity(SeverityLevel.NORMAL)
    void headerNavigation(HeaderCategoryCase tc) {


        Allure.story(tc.story());

        new HomePage(driver()).open(baseUrl()).clickHeaderLink(tc.cssToClick);


        Assertions.assertThat(driver().getCurrentUrl()).contains(tc.urlContains);

    }

}
