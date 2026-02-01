package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOptionsPage extends BasePage {

    private static final By LOGIN_NAME_INPUT = By.id("loginFrm_loginname");
    private static final By PASSWORD_INPUT = By.id("loginFrm_password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[title=\"Login\"]");
    private static final By GUEST_CHECKOUT_RADIO_BUTTON = By.id("accountFrm_accountguest");
    private static final By REGISTER_ACCOUNT_RADIO_BUTTON = By.id("accountFrm_accountregister");
    private static final By NEW_CUSTOMER_SELECTION_CONFIRMATION_BUTTON = By.cssSelector("button[title=\"Continue\"]");

    public CheckoutOptionsPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOptionsPage waitUntilLoaded() {
        waits.urlContains("account/login");
        return this;
    }

    public CheckoutOptionsPage typeLogin(String login) {
        type(LOGIN_NAME_INPUT, login);
        return this;
    }

    public CheckoutOptionsPage typePassword(String password) {
        type(PASSWORD_INPUT, password);
        return this;
    }

    public CheckoutOptionsPage submitLogin() {
        click(LOGIN_BUTTON);

        return this;
    }

    public CheckoutOptionsPage continueAsAGuest() {
        click(GUEST_CHECKOUT_RADIO_BUTTON);
        click(NEW_CUSTOMER_SELECTION_CONFIRMATION_BUTTON);

        return this;
    }

    public CheckoutOptionsPage continueWithRegistration() {
        click(REGISTER_ACCOUNT_RADIO_BUTTON);
        click(NEW_CUSTOMER_SELECTION_CONFIRMATION_BUTTON);

        return this;
    }

}
