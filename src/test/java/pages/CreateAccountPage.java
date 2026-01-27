package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage{

    private static final By FirstNameInput = By.id("AccountFrm_firstname");
    private static final By LastNameInput = By.id("AccountFrm_lastname");
    private static final By EmailInput = By.id("AccountFrm_email");
    private static final By PhoneInput = By.id("AccountFrm_telephone");
    private static final By Address1Input = By.id("AccountFrm_address_1");
    private static final By CityInput = By.id("AccountFrm_city");
    private static final By RegionDropdown = By.id("AccountFrm_zone_id");
    private static final By ZipCodeInput = By.id("AccountFrm_postcode");
    private static final By LoginInput = By.id("AccountFrm_loginname");
    private static final By PasswordInput = By.id("AccountFrm_password");
    private static final By PasswordConfirmInput = By.id("AccountFrm_confirm");
    private static final By PrivacyPolicyButton = By.id("AccountFrm_agree");
    private static final By ContinueButton = By.cssSelector("[title=\"Continue\"]");
    private static final By Success_Message = By.cssSelector(".maintext");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage open(String baseUrl) {
        driver.get(baseUrl + "/index.php?rt=account/create");
        waits.visible(FirstNameInput);
        return this;
    }

    public CreateAccountPage waitUntilLoaded() {
        waits.urlContains("account/create");
        return this;
    }

    public CreateAccountPage typeFirstName(String firstName) {
        waits.visible(FirstNameInput).clear();
        waits.visible(FirstNameInput).sendKeys(firstName);
        return this;
    }

    public CreateAccountPage typeLastName(String lastName) {
        waits.visible(LastNameInput).clear();
        waits.visible(LastNameInput).sendKeys(lastName);
        return this;
    }

    public CreateAccountPage typeEmailAddress(String email) {
        waits.visible(EmailInput).clear();
        waits.visible(EmailInput).sendKeys(email);
        return this;
    }

    public CreateAccountPage typePhoneNumber(String phone) {
        waits.visible(PhoneInput).clear();
        waits.visible(PhoneInput).sendKeys(phone);
        return this;
    }

    public CreateAccountPage typeAddress1(String address1) {
        waits.visible(Address1Input).clear();
        waits.visible(Address1Input).sendKeys(address1);
        return this;
    }

    public CreateAccountPage typeCity(String city) {
        waits.visible(CityInput).clear();
        waits.visible(CityInput).sendKeys(city);
        return this;
    }

    public CreateAccountPage selectRegion(String region) {
        Select select = new Select(waits.visible(RegionDropdown));
        select.selectByVisibleText(region);
        return this;
    }

    public CreateAccountPage typeZipCode(String zipCode) {
        waits.visible(ZipCodeInput).clear();
        waits.visible(ZipCodeInput).sendKeys(zipCode);
        return this;
    }

    public CreateAccountPage typeLogin(String login) {
        waits.visible(LoginInput).clear();
        waits.visible(LoginInput).sendKeys(login);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        waits.visible(PasswordInput).clear();
        waits.visible(PasswordInput).sendKeys(password);
        return this;
    }

    public CreateAccountPage typePasswordConfirmation(String password) {
        waits.visible(PasswordConfirmInput).clear();
        waits.visible(PasswordConfirmInput).sendKeys(password);
        return this;
    }

    public CreateAccountPage confirmPrivacyPolicy() {
        var checkbox = waits.clickable(PrivacyPolicyButton);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        return this;
    }

    public CreateAccountPage submitForm() {

        waits.scrollIntoView(ContinueButton);
        waits.safeClick(ContinueButton);

        return this;
    }

    public String successMessageText() {
        return waits.visible(Success_Message).getText();
    }
}