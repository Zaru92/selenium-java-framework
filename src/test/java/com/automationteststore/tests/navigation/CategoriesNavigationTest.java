package com.automationteststore.tests.navigation;

import com.automationteststore.core.BaseTest;
import com.automationteststore.pages.HomePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Epic("AutomationTestStore")
@Feature("Navigation")
@Execution(ExecutionMode.SAME_THREAD)
public class CategoriesNavigationTest extends BaseTest {

    record CategoryCase(String story, String cssToClick, String expectedHeader) {
        @Override
        public String toString() {
            return story;
        }
    }

    static Stream<CategoryCase> categoryCases() {
        return Stream.of(
                new CategoryCase("Navigate to Apparel & Accessories Category", ".categorymenu > li:nth-of-type(2)", "APPAREL & ACCESSORIES"),
                new CategoryCase("Navigate to Makeup Category", ".categorymenu > li:nth-of-type(3)", "MAKEUP"),
                new CategoryCase("Navigate to Skincare Category", ".categorymenu > li:nth-of-type(4)", "SKINCARE"),
                new CategoryCase("Navigate to Fragrance Category", ".categorymenu > li:nth-of-type(5)", "FRAGRANCE"),
                new CategoryCase("Navigate to Men Category", ".categorymenu > li:nth-of-type(6)", "MEN"),
                new CategoryCase("Navigate to Hair Care Category", ".categorymenu > li:nth-of-type(7)", "HAIR CARE"),
                new CategoryCase("Navigate to Books Category", ".categorymenu > li:nth-of-type(8)", "BOOKS")
        );
    }

    @ParameterizedTest(name = "{index} => {0}")
    @MethodSource("categoryCases")
    @Severity(SeverityLevel.NORMAL)
    void navigateToCategory(CategoryCase tc) {

        Allure.story(tc.story());

        HomePage homePage = new HomePage(driver())
                .open(baseUrl())
                .clickCategory(tc.cssToClick);

        Assertions.assertThat(homePage.categoryHeaderText())
                .isEqualTo(tc.expectedHeader);
    }
}
