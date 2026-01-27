package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public static final By CATEGORY_HEADER = By.cssSelector(".maintext");
    private static final By MAIN_CONTAINER = By.id("maincontainer");
    private static final By CART_COUNTER = By.cssSelector(".block_7 a > .label-orange");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String baseUrl) {
        for (int i = 0; i < 2; i++) {
            driver.get(baseUrl);
            try {
                waits.documentReady();
                waits.visible(MAIN_CONTAINER);
                return this;
            } catch (Exception e) {
                if (i == 1) throw e;
            }
        }
        return this;
    }

    public HomePage clickCategory(String cssSelector) {
        By categoryLink = By.cssSelector(cssSelector);

        waits.scrollIntoView(categoryLink);
        waits.safeClick(categoryLink);

        waits.visible(CATEGORY_HEADER);

        return this;
    }

    public HomePage clickHeaderLink(String cssSelector) {
        By headerCategoryLink = By.cssSelector(cssSelector);

        waits.scrollIntoView(headerCategoryLink);
        waits.safeClick(headerCategoryLink);

        return this;
    }

    public HomePage addFirstProductToCart() {
        By firstProductAddToCartButton = By.cssSelector(".productcart");

        waits.scrollIntoView(firstProductAddToCartButton);
        waits.safeClick(firstProductAddToCartButton);
        waits.textToBe(CART_COUNTER, "1");


        return this;
    }



}
