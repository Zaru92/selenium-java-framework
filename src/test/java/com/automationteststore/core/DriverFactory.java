package com.automationteststore.core;

import com.automationteststore.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {

    public static WebDriver create() {
        BrowserType browser = BrowserType.from(TestConfig.browser());

        return switch (browser) {
            case CHROME -> createChrome();
            case FIREFOX -> createFirefox();
            case EDGE -> createEdge();
            case SAFARI -> createSafari();
        };
    }

    // ===== CHROME =====
    private static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--window-size=1400,900");

        if (TestConfig.headless()) {
            options.addArguments("--headless=new");
        }

        return new ChromeDriver(options);
    }

    // ===== FIREFOX =====
    private static WebDriver createFirefox() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--width=1400");
        options.addArguments("--height=900");

        if (TestConfig.headless()) {
            options.addArguments("-headless");
        }

        return new FirefoxDriver(options);
    }

    // ===== EDGE =====
    private static WebDriver createEdge() {
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);

        if (TestConfig.headless()) {
            options.addArguments("--headless=new");
        }

        return new EdgeDriver(options);
    }

    // ===== SAFARI =====
    private static WebDriver createSafari() {
        // Safari tylko na macOS
        String os = System.getProperty("os.name").toLowerCase();
        if (!os.contains("mac")) {
            throw new IllegalStateException("Safari is supported only on macOS");
        }

        if (TestConfig.headless()) {
            throw new IllegalStateException("Safari does not support headless mode in typical WebDriver usage");
        }

        SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }

}
