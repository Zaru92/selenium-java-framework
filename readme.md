# Selenium Java Automation Framework

A modern UI test automation framework built with **Selenium + Java + JUnit 5**. The project is prepared in a **production/portfolio-ready** style, with solid architecture, reporting, logging, and multi-browser execution support.

---

## 🧰 Tech Stack

- **Java 17+**
- **Selenium 4**
- **JUnit 5 (Jupiter)**
- **Gradle (Kotlin DSL)**
- **WebDriverManager** – automatic driver management
- **AssertJ** – fluent assertions
- **SLF4J + Logback** – logging
- **Allure Report** – HTML reports

---

## 📂 Project Structure

```
selenium-java-framework
├── build.gradle.kts
├── settings.gradle.kts
├── readme.md
└── src
    ├── main
    │   └── java
    │       └── org/example/Main.java
    └── test
        ├── java/com/automationteststore
        │   ├── config
        │   │   └── TestConfig.java
        │   ├── core
        │   │   ├── AllureAttachments.java
        │   │   ├── BaseTest.java
        │   │   ├── BrowserType.java
        │   │   ├── DriverFactory.java
        │   │   ├── DriverManager.java
        │   │   ├── ScreenshotOnFailureExtension.java
        │   │   └── Waits.java
        │   ├── pages
        │   │   ├── BasePage.java
        │   │   ├── AccountLoginPage.java
        │   │   ├── CartPage.java
        │   │   ├── CheckoutConfirmationPage.java
        │   │   ├── CheckoutOptionsPage.java
        │   │   ├── CheckoutSuccessPage.java
        │   │   ├── CreateAccountPage.java
        │   │   ├── GuestCheckoutFormPage.java
        │   │   └── HomePage.java
        │   ├── testdata
        │   │   ├── factory
        │   │   │   ├── AddressFactory.java
        │   │   │   ├── CredentialsFactory.java
        │   │   │   └── UserFactory.java
        │   │   ├── model
        │   │   │   ├── AddressData.java
        │   │   │   ├── Credentials.java
        │   │   │   └── UserData.java
        │   │   └── store
        │   │       └── CreatedAccountsStore.java
        │   └── tests
        │       ├── account
        │       │   ├── CreateAccountTest.java
        │       │   ├── InvalidLoginTest.java
        │       │   └── ValidLoginTest.java
        │       ├── cart
        │       │   ├── AddToCartTest.java
        │       │   ├── DeleteItemTest.java
        │       │   └── OpenEmptyCartTest.java
        │       ├── checkout
        │       │   ├── CheckoutLoginDuringFlowTest.java
        │       │   ├── CheckoutRegisterDuringFlowTest.java
        │       │   └── GuestCheckoutTest.java
        │       └── navigation
        │           ├── CategoriesNavigationTest.java
        │           ├── HeaderNavigationTest.java
        │           └── OpenHomePageTest.java
        └── resources
            ├── config.properties
            ├── junit-platform.properties
            └── logback-test.xml
```

---

## 🧠 Architecture – Key Concepts

### Page Object Model (POM)
- Each page is represented by a dedicated class.
- Page Objects **do not contain assertions** – they only expose user actions.
- Methods reflect real user steps (e.g., `open`, `typeLogin`, `submit`).

### ThreadLocal WebDriver
- Each test uses **its own WebDriver instance**.
- The architecture is ready for parallel execution.

### BaseTest
- Centralized test lifecycle management.
- `@BeforeEach` – WebDriver initialization.
- `@AfterEach` – resource cleanup.
- Integrates **Allure** + automatic screenshots on failure.

---

## 📸 Screenshots on Failure

- A screenshot is captured **automatically when a test fails**.
- Location:
  ```
  build/reports/screenshots/
  ```
- The same image is attached to the Allure report.

---

## 📝 Logging (SLF4J + Logback)

- Logs are available in the console and in a file:
  ```
  build/logs/tests.log
  ```
- Responsibility split:
  - **BaseTest** – test start/end
  - **Page Objects** – user actions
  - **Tests** – intent and assertions

---

## 📊 Reporting – Allure

The Allure report includes:
- test execution status
- steps (`@Step`)
- labels (`@Epic`, `@Feature`, `@Story`, `@Severity`)
- screenshots and logs

### Report generation

The report is generated automatically after test execution:

```bash
./gradlew test
```

Report location:
```
build/reports/allure-report/index.html
```

---

## 🧪 Running Tests

### Run all tests
```bash
./gradlew test
```

### Run a single test
```bash
./gradlew test --tests "tests.account.InvalidLoginTest.invalidLoginTest"
```

### Force a local run
```bash
./gradlew test --rerun-tasks
```

---

## 🌍 Multi-Browser Execution

The framework supports running tests on different browsers via the `-Dbrowser` system property.

Supported values:
- `chrome`
- `firefox`
- `edge`

Example (headless):
```bash
./gradlew test -Dbrowser=chrome -Dheadless=true
```

### ✅ Example Firefox runner

```bash
./gradlew test -Dbrowser=firefox -Dheadless=false
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

All values can be overridden via `-D` parameters (CI-friendly).

---

## 🔀 Parallel Execution (Status)

Parallel and parameterized execution is currently disabled due to instability of the target environment (dynamic content and inconsistent UI state).
The framework itself is prepared for parallel runs and can be re-enabled once the environment stabilizes.

---

## 🚀 Future Improvements

The framework is ready for:
- parallel execution (JUnit 5 + ThreadLocal)
- CI integration (GitHub Actions / others)
- retry mechanisms and advanced test data management
- API tests

---

## 👤 Author

This project was created as a **portfolio framework** to showcase UI test automation skills using Java and Selenium.

---

💡 To run the project locally: clone the repository, execute `./gradlew test`, and open the generated Allure report.
