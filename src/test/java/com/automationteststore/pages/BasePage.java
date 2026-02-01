package com.automationteststore.pages;

import com.automationteststore.core.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final Waits waits;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }

    protected void type(By locator, String value) {
        WebElement element = waits.visible(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected void click(By locator) {
        waits.scrollIntoView(locator);
        waits.safeClick(locator);
    }

    protected String textOf(By locator) {
        return waits.visible(locator).getText();
    }
}
