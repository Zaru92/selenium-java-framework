package com.automationteststore.core;

import com.automationteststore.config.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    protected Waits waits;

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    void setUp(TestInfo testInfo) {
        log.info("[{}] === START TEST: {} ===", Thread.currentThread().getName(), testInfo.getDisplayName());
        log.info("System property browser = {}", System.getProperty("browser"));
        log.info("Browser: {}", TestConfig.browser());

        WebDriver driver = DriverFactory.create();
        DriverManager.set(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        waits = new Waits(driver);
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        log.info("[{}] === END TEST: {} ===", Thread.currentThread().getName(), testInfo.getDisplayName());

        DriverManager.quit();
    }

    protected WebDriver driver() {
        return DriverManager.get();
    }

    protected String baseUrl() {
        return TestConfig.baseUrl();
    }

}
