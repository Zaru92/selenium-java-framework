package core;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void set(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver get() {
        return driver.get();
    }

    public static void quit() {
        WebDriver webDriver = driver.get();

        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}
