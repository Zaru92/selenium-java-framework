package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLoginPage extends BasePage {

    private static final By loginNameInput = By.id("loginFrm_loginname");
    private static final By passwordInput = By.id("loginFrm_password");
    private static final By loginButton = By.cssSelector("button[title=\"Login\"]");
    private static final By alertBox = By.cssSelector(".alert-danger");

    public AccountLoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountLoginPage open(String baseUrl) {
        driver.get(baseUrl + "/index.php?rt=account/login");
        waits.visible(loginNameInput);
        return this;
    }

    public AccountLoginPage typeLogin(String login) {
        waits.visible(loginNameInput).clear();
        waits.visible(loginNameInput).sendKeys(login);
        return this;
    }

    public AccountLoginPage typePassword(String password) {
        waits.visible(passwordInput).clear();
        waits.visible(passwordInput).sendKeys(password);
        return this;
    }

    public AccountLoginPage submit() {
        waits.scrollIntoView(loginButton);
        waits.safeClick(loginButton);

        return this;
    }


    public String alertText() {
        return waits.visible(alertBox).getText();
    }

}
