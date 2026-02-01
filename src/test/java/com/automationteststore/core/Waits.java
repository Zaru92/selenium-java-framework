package com.automationteststore.core;

import com.automationteststore.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Waits(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestConfig.timeoutSeconds()));
    }

    public WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean urlContains(String value) {
        return wait.until(ExpectedConditions.urlContains(value));
    }

    public void documentReady() {
        wait.until(d -> {
            String state = (String) ((JavascriptExecutor) d).executeScript("return document.readyState");
            return "complete".equals(state) || "interactive".equals(state);
        });
    }

    public void scrollIntoView(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});", el
        );
    }

    public void safeClick(By locator) {
        try {
            clickable(locator).click();
        } catch (ElementClickInterceptedException | TimeoutException e) {
            WebElement el = visible(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }

    public boolean textToBe(By locator, String expectedText) {
        return wait.until(ExpectedConditions.textToBe(locator, expectedText));
    }

}
