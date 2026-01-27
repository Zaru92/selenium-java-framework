package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutConfirmationPage extends BasePage {

    private static final By confirmOrderButton = By.id("checkout_btn");

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutConfirmationPage waitUntilLoaded() {
        waits.urlContains("checkout/confirm");
        return this;
    }


    public CheckoutConfirmationPage waitUntilLoadedAsAGuest() {
        waits.urlContains("checkout/guest_step_3");
        return this;
    }

    public CheckoutConfirmationPage confirmOrder() {

        waits.scrollIntoView(confirmOrderButton);
        waits.safeClick(confirmOrderButton);

        return this;
    }

}
