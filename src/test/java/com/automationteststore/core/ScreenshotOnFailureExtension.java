package com.automationteststore.core;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotOnFailureExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        // JUnit trzyma info o exception z testu w store
        Throwable throwable = context.getExecutionException().orElse(null);
        if (throwable == null) return; // test passed → nie robimy screena

        var driver = DriverManager.get();
        if (driver == null) return;

        try {
            byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AllureAttachments.attachPng("Screenshot on failure", png);

            String className = context.getRequiredTestClass().getSimpleName();
            String methodName = context.getRequiredTestMethod().getName();
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            Path dir = Path.of("build", "reports", "screenshots");
            Files.createDirectories(dir);

            Path file = dir.resolve(className + "_" + methodName + "_" + ts + ".png");
            Files.write(file, png);

            System.out.println("Saved screenshot: " + file.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Could not save screenshot: " + e.getMessage());
        }
    }
}
