package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GuestCheckoutFomPage extends BasePage {

    private static final By FirstNameInput = By.id("guestFrm_firstname");
    private static final By LastNameInput = By.id("guestFrm_lastname");
    private static final By EmailInput = By.id("guestFrm_email");
    private static final By PhoneInput = By.id("guestFrm_telephone");
    private static final By Address1Input = By.id("guestFrm_address_1");
    private static final By CityInput = By.id("guestFrm_city");
    private static final By RegionDropdown = By.id("guestFrm_zone_id");
    private static final By ZipCodeInput = By.id("guestFrm_postcode");
    private static final By LoginInput = By.id("guestFrm_loginname");
    private static final By PasswordInput = By.id("guestFrm_password");
    private static final By PasswordConfirmInput = By.id("guestFrm_confirm");
    private static final By PrivacyPolicyButton = By.id("guestFrm_agree");
    private static final By ContinueButton = By.cssSelector("[title=\"Continue\"]");

    public GuestCheckoutFomPage(WebDriver driver) {
        super(driver);
    }

    public GuestCheckoutFomPage waitUntilLoaded() {
        waits.urlContains("checkout/guest_step_1");
        return this;
    }

    public GuestCheckoutFomPage typeFirstName(String firstName) {
        waits.visible(FirstNameInput).clear();
        waits.visible(FirstNameInput).sendKeys(firstName);
        return this;
    }

    public GuestCheckoutFomPage typeLastName(String lastName) {
        waits.visible(LastNameInput).clear();
        waits.visible(LastNameInput).sendKeys(lastName);
        return this;
    }

    public GuestCheckoutFomPage typeEmailAddress(String email) {
        waits.visible(EmailInput).clear();
        waits.visible(EmailInput).sendKeys(email);
        return this;
    }

    public GuestCheckoutFomPage typePhoneNumber(String phone) {
        waits.visible(PhoneInput).clear();
        waits.visible(PhoneInput).sendKeys(phone);
        return this;
    }

    public GuestCheckoutFomPage typeAddress1(String address1) {
        waits.visible(Address1Input).clear();
        waits.visible(Address1Input).sendKeys(address1);
        return this;
    }

    public GuestCheckoutFomPage typeCity(String city) {
        waits.visible(CityInput).clear();
        waits.visible(CityInput).sendKeys(city);
        return this;
    }

    public GuestCheckoutFomPage selectRegion(String region) {
        Select select = new Select(waits.visible(RegionDropdown));
        select.selectByVisibleText(region);
        return this;
    }

    public GuestCheckoutFomPage typeZipCode(String zipCode) {
        waits.visible(ZipCodeInput).clear();
        waits.visible(ZipCodeInput).sendKeys(zipCode);
        return this;
    }

    public GuestCheckoutFomPage typeLogin(String login) {
        waits.visible(LoginInput).clear();
        waits.visible(LoginInput).sendKeys(login);
        return this;
    }

    public GuestCheckoutFomPage typePassword(String password) {
        waits.visible(PasswordInput).clear();
        waits.visible(PasswordInput).sendKeys(password);
        return this;
    }

    public GuestCheckoutFomPage typePasswordConfirmation(String password) {
        waits.visible(PasswordConfirmInput).clear();
        waits.visible(PasswordConfirmInput).sendKeys(password);
        return this;
    }

    public GuestCheckoutFomPage submitForm() {

        waits.scrollIntoView(ContinueButton);
        waits.safeClick(ContinueButton);

        return this;
    }

}
