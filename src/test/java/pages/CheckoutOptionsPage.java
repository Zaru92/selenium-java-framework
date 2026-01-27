package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOptionsPage extends BasePage {

    private static final By loginNameInput = By.id("loginFrm_loginname");
    private static final By passwordInput = By.id("loginFrm_password");
    private static final By loginButton = By.cssSelector("button[title=\"Login\"]");
    private static final By guestCheckoutRadioButton = By.id("accountFrm_accountguest");
    private static final By registerAccountRadioButton = By.id("accountFrm_accountregister");
    private static final By newCustomerSelectionConfirmationButton = By.cssSelector("button[title=\"Continue\"]");

    public CheckoutOptionsPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOptionsPage waitUntilLoaded() {
        waits.urlContains("account/login");
        return this;
    }

    public CheckoutOptionsPage typeLogin(String login) {
        waits.visible(loginNameInput).clear();
        waits.visible(loginNameInput).sendKeys(login);
        return this;
    }

    public CheckoutOptionsPage typePassword(String password) {
        waits.visible(passwordInput).clear();
        waits.visible(passwordInput).sendKeys(password);
        return this;
    }

    public CheckoutOptionsPage submitLogin() {

        waits.scrollIntoView(loginButton);
        waits.safeClick(loginButton);

        return this;
    }

    public CheckoutOptionsPage continueAsAGuest() {

        waits.scrollIntoView(guestCheckoutRadioButton);
        waits.safeClick(guestCheckoutRadioButton);

        waits.scrollIntoView(newCustomerSelectionConfirmationButton);
        waits.safeClick(newCustomerSelectionConfirmationButton);

        return this;
    }

    public CheckoutOptionsPage continueWithRegistration() {

        waits.scrollIntoView(registerAccountRadioButton);
        waits.safeClick(registerAccountRadioButton);

        waits.scrollIntoView(newCustomerSelectionConfirmationButton);
        waits.safeClick(newCustomerSelectionConfirmationButton);

        return this;
    }

}
