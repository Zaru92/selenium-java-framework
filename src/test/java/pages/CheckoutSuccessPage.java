package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSuccessPage extends BasePage{

    private static final By ContinueButton = By.cssSelector("[title=\"Continue\"]");

    public CheckoutSuccessPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutSuccessPage continueFromSuccessPage() {

        waits.scrollIntoView(ContinueButton);
        waits.safeClick(ContinueButton);

        return this;
    }

    public CheckoutSuccessPage waitUntilLoaded() {
        waits.urlContains("checkout/success");
        return this;
    }
}
