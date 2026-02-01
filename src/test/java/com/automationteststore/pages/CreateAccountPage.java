package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.id("AccountFrm_firstname");
    private static final By LAST_NAME_INPUT = By.id("AccountFrm_lastname");
    private static final By EMAIL_INPUT = By.id("AccountFrm_email");
    private static final By PHONE_INPUT = By.id("AccountFrm_telephone");
    private static final By ADDRESS_1_INPUT = By.id("AccountFrm_address_1");
    private static final By CITY_INPUT = By.id("AccountFrm_city");
    private static final By REGION_DROPDOWN = By.id("AccountFrm_zone_id");
    private static final By ZIP_CODE_INPUT = By.id("AccountFrm_postcode");
    private static final By LOGIN_INPUT = By.id("AccountFrm_loginname");
    private static final By PASSWORD_INPUT = By.id("AccountFrm_password");
    private static final By PASSWORD_CONFIRM_INPUT = By.id("AccountFrm_confirm");
    private static final By PRIVACY_POLICY_BUTTON = By.id("AccountFrm_agree");
    private static final By CONTINUE_BUTTON = By.cssSelector("[title=\"Continue\"]");
    private static final By SUCCESS_MESSAGE = By.cssSelector(".maintext");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage open(String baseUrl) {
        driver.get(baseUrl + "/index.php?rt=account/create");
        waits.visible(FIRST_NAME_INPUT);
        return this;
    }

    public CreateAccountPage waitUntilLoaded() {
        waits.urlContains("account/create");
        return this;
    }

    public CreateAccountPage typeFirstName(String firstName) {
        type(FIRST_NAME_INPUT, firstName);
        return this;
    }

    public CreateAccountPage typeLastName(String lastName) {
        type(LAST_NAME_INPUT, lastName);
        return this;
    }

    public CreateAccountPage typeEmailAddress(String email) {
        type(EMAIL_INPUT, email);
        return this;
    }

    public CreateAccountPage typePhoneNumber(String phone) {
        type(PHONE_INPUT, phone);
        return this;
    }

    public CreateAccountPage typeAddress1(String address1) {
        type(ADDRESS_1_INPUT, address1);
        return this;
    }

    public CreateAccountPage typeCity(String city) {
        type(CITY_INPUT, city);
        return this;
    }

    public CreateAccountPage selectRegion(String region) {
        Select select = new Select(waits.visible(REGION_DROPDOWN));
        select.selectByVisibleText(region);
        return this;
    }

    public CreateAccountPage typeZipCode(String zipCode) {
        type(ZIP_CODE_INPUT, zipCode);
        return this;
    }

    public CreateAccountPage typeLogin(String login) {
        type(LOGIN_INPUT, login);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        type(PASSWORD_INPUT, password);
        return this;
    }

    public CreateAccountPage typePasswordConfirmation(String password) {
        type(PASSWORD_CONFIRM_INPUT, password);
        return this;
    }

    public CreateAccountPage confirmPrivacyPolicy() {
        var checkbox = waits.clickable(PRIVACY_POLICY_BUTTON);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        return this;
    }

    public CreateAccountPage submitForm() {
        click(CONTINUE_BUTTON);

        return this;
    }

    public String successMessageText() {
        return textOf(SUCCESS_MESSAGE);
    }
}
