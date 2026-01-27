# Selenium Java Automation Framework

A professional UI test automation framework based on **Selenium + Java + JUnit 5**, prepared in a **production-ready / portfolio-ready** style.

This project demonstrates solid architectural practices (Page Object Model, ThreadLocal WebDriver, Test Data Factory), automatic Allure reporting, logging, and readiness for parallel execution and CI pipelines.

---

## 🧰 Tech Stack

- **Java 17+**
- **Selenium 4**
- **JUnit 5 (Jupiter)**
- **Gradle (Kotlin DSL)**
- **WebDriverManager** – automatic driver management
- **AssertJ** – fluent assertions
- **SLF4J + Logback** – logging
- **Allure Report** – HTML reporting

---

## 📂 Project Structure

```
selenium-java-framework
├── build.gradle.kts
├── settings.gradle.kts
├── README.md
└── src
    ├── test
    │   ├── java
    │   │   ├── core
    │   │   │   ├── BaseTest.java
    │   │   │   ├── DriverFactory.java
    │   │   │   ├── DriverManager.java
    │   │   │   ├── ScreenshotOnFailureExtension.java
    │   │   │   └── AllureAttachments.java
    │   │   ├── config
    │   │   │   └── TestConfig.java
    │   │   ├── pages
    │   │   │   ├── BasePage.java
    │   │   │   ├── HomePage.java
    │   │   │   └── AccountLoginPage.java
    │   │   ├── pages/components
    │   │   │   └── HeaderComponent.java
    │   │   └── tests
    │   │       └── InvalidLoginTest.java
    │   └── resources
    │       ├── junit-platform.properties
    │       ├── logback-test.xml
    │       └── config.properties
```

---

## 🧠 Architecture – Key Concepts

### Page Object Model (POM)
- Each page is represented by a separate class
- Page Objects **do not contain assertions**
- Methods reflect real user actions (`open`, `typeLogin`, `submit`)

### ThreadLocal WebDriver
- Each test runs with its **own WebDriver instance**
- Fully **parallel-execution ready**
- No driver conflicts between tests

### BaseTest
- Centralized test lifecycle management
- `@BeforeEach` – WebDriver initialization
- `@AfterEach` – resource cleanup
- Extensions: screenshots + Allure attachments

---

## 📸 Screenshots on Failure

- A screenshot is taken **automatically when a test fails**
- Saved to:
  ```
  build/reports/screenshots/
  ```
- The same screenshot is also attached directly to the **Allure Report**

---

## 📝 Logging (SLF4J + Logback)

- Logs printed to the console
- Logs saved to file:
  ```
  build/logs/tests.log
  ```
- Clear responsibility split:
  - **BaseTest** – test start / end
  - **Page Objects** – user actions
  - **Tests** – assertion intent

---

## 📊 Reporting – Allure

Allure generates a clear and readable HTML report containing:
- test execution status
- steps (`@Step`)
- labels (`@Epic`, `@Feature`, `@Story`, `@Severity`)
- screenshots and logs

### Report generation

The report is generated **automatically after each test run**:

```bash
./gradlew test
```

Report location:
```
build/reports/allure-report/index.html
```

---

## 🔀 Parallel Execution (Current Status)

Parallel and parameterized execution is currently disabled due to instability of the target test environment (dynamic content, inconsistent UI state).
The framework itself is fully prepared for parallel execution and can be safely re-enabled once the environment becomes stable.

---

## 🧪 Example Test

```java
@Epic("AutomationTestStore")
@Feature("Login")
public class InvalidLoginTest extends BaseTest {

    @Test
    @Story("Invalid login shows error")
    @Severity(SeverityLevel.CRITICAL)
    void invalidLoginTest() {
        var login = new AccountLoginPage(driver())
                .open(baseUrl())
                .typeLogin("wrong_user")
                .typePassword("wrong_pass")
                .submit();

        assertThat(login.alertText())
                .contains("Error: Incorrect login or password provided");
    }
}
```

---

## ▶️ Running Tests

### Run all tests
```bash
./gradlew test
```

### Run a single test
```bash
./gradlew test --tests "tests.InvalidLoginTest.invalidLoginTest"
```

### Runtime parameters
```bash
./gradlew test -Dbrowser=chrome -Dheadless=true
```
### To force test execution locally
```bash
./gradlew test --rerun-tasks
```

---

## ⚙️ Configuration

`config.properties`:
```properties
baseUrl=https://automationteststore.com
browser=chrome
headless=false
timeoutSeconds=10
```

All properties can be overridden using JVM `-D` parameters (CI-friendly).

---

## 🚀 CI / Future Improvements

The framework is ready for:
- parallel execution (JUnit 5 + ThreadLocal)
- GitHub Actions / CI pipelines
- extension with retries, API tests, advanced test data management

---

## 👤 Author

This project was created as a **portfolio framework** to showcase UI test automation skills using Java and Selenium.

---

## 📌 Why this project?

- demonstrates **clean code and solid architecture**
- uses **tools common in commercial projects**
- easy to extend and maintain
- clear and readable for recruiters and development teams

---

💡 To run the project locally: clone the repository, execute `./gradlew test`, and open the generated Allure report.

