package com.automationteststore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GuestCheckoutFormPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.id("guestFrm_firstname");
    private static final By LAST_NAME_INPUT = By.id("guestFrm_lastname");
    private static final By EMAIL_INPUT = By.id("guestFrm_email");
    private static final By PHONE_INPUT = By.id("guestFrm_telephone");
    private static final By ADDRESS_1_INPUT = By.id("guestFrm_address_1");
    private static final By CITY_INPUT = By.id("guestFrm_city");
    private static final By REGION_DROPDOWN = By.id("guestFrm_zone_id");
    private static final By ZIP_CODE_INPUT = By.id("guestFrm_postcode");
    private static final By CONTINUE_BUTTON = By.cssSelector("[title=\"Continue\"]");

    public GuestCheckoutFormPage(WebDriver driver) {
        super(driver);
    }

    public GuestCheckoutFormPage waitUntilLoaded() {
        waits.urlContains("checkout/guest_step_1");
        return this;
    }

    public GuestCheckoutFormPage typeFirstName(String firstName) {
        type(FIRST_NAME_INPUT, firstName);
        return this;
    }

    public GuestCheckoutFormPage typeLastName(String lastName) {
        type(LAST_NAME_INPUT, lastName);
        return this;
    }

    public GuestCheckoutFormPage typeEmailAddress(String email) {
        type(EMAIL_INPUT, email);
        return this;
    }

    public GuestCheckoutFormPage typePhoneNumber(String phone) {
        type(PHONE_INPUT, phone);
        return this;
    }

    public GuestCheckoutFormPage typeAddress1(String address1) {
        type(ADDRESS_1_INPUT, address1);
        return this;
    }

    public GuestCheckoutFormPage typeCity(String city) {
        type(CITY_INPUT, city);
        return this;
    }

    public GuestCheckoutFormPage selectRegion(String region) {
        Select select = new Select(waits.visible(REGION_DROPDOWN));
        select.selectByVisibleText(region);
        return this;
    }

    public GuestCheckoutFormPage typeZipCode(String zipCode) {
        type(ZIP_CODE_INPUT, zipCode);
        return this;
    }

    public GuestCheckoutFormPage submitForm() {
        click(CONTINUE_BUTTON);

        return this;
    }

}
