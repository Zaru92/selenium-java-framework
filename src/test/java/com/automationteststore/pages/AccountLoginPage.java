package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLoginPage extends BasePage {

    private static final By LOGIN_NAME_INPUT = By.id("loginFrm_loginname");
    private static final By PASSWORD_INPUT = By.id("loginFrm_password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[title=\"Login\"]");
    private static final By ALERT_BOX = By.cssSelector(".alert-danger");

    public AccountLoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountLoginPage open(String baseUrl) {
        driver.get(baseUrl + "/index.php?rt=account/login");
        waits.visible(LOGIN_NAME_INPUT);
        return this;
    }

    public AccountLoginPage typeLogin(String login) {
        type(LOGIN_NAME_INPUT, login);
        return this;
    }

    public AccountLoginPage typePassword(String password) {
        type(PASSWORD_INPUT, password);
        return this;
    }

    public AccountLoginPage submit() {
        click(LOGIN_BUTTON);

        return this;
    }


    public String alertText() {
        return textOf(ALERT_BOX);
    }

}
