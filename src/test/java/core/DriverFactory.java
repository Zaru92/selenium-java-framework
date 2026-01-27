package core;

import config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver create() {
        String browser = TestConfig.browser().toLowerCase();

        return switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(chromeOptions());
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(chromeOptions());
            }
        };
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.setAcceptInsecureCerts(true);

        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        options.addArguments("--window-size=1400,900");

        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-background-networking");
        options.addArguments("--disable-background-timer-throttling");
        options.addArguments("--disable-renderer-backgrounding");

        if (TestConfig.headless()) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}
