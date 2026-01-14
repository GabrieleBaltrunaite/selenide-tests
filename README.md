# IMDb UI Automation Framework

This project provides a simple UI automation framework for testing IMDb functionality using **Java 17**, **Selenide** (Selenium wrapper), **TestNG**, and **Allure Reports**.

## 🛠 Prerequisites

- **Java:** JDK 17 or higher.
- **Gradle:** 8.5+ (Wrapper included).

## 🚀 Running Tests

You can run the tests using the Gradle wrapper. 
- **On Linux/macOS:** Use `./gradlew`
- **On Windows:** Use `gradlew.bat` or just `gradlew` (in PowerShell/CMD).

By default, tests run on **Chrome** in **headed** mode.

### Basic Execution
```bash
# Linux/macOS
./gradlew clean test

# Windows
gradlew clean test
```

### Running Specific Tests
You can run a specific test class or a specific test method using the `--tests` flag:

*   **Run a specific test class:**
    ```bash
    ./gradlew test --tests "com.imdb.tests.ImdbSearchTest"
    ```
*   **Run a specific test method:**
    ```bash
    ./gradlew test --tests "com.imdb.tests.ImdbSearchTest.testImdbSearchAndCastMemberView"
    ```

### Browser Options
You can configure the browser and other settings using system properties:

*   **Change Browser:** Run on Firefox, Edge, etc.
    ```bash
    ./gradlew test -Dselenide.browser=firefox
    # Or for Edge
    ./gradlew test -Dselenide.browser=edge
    ```
*   **Headless Mode:** Run without a browser UI.
    ```bash
    ./gradlew test -Dselenide.headless=true
    ```
*   **Custom Resolution:**
    ```bash
    ./gradlew test -Dselenide.browserSize=1280x720
    ```

## 💡 Testing Tips & Tricks

### Headless Chrome & Bot Detection
IMDb uses bot detection that often blocks standard **Headless Chrome** (returning a `403 Forbidden` error). To bypass this, we mimic a real user by overriding the `User-Agent` and disabling automation flags.

**Command for verified Headless Chrome:**
```bash
./gradlew clean test -Dselenide.browser=chrome -Dselenide.headless=true -Dchromeoptions.args="--user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36',--disable-blink-features=AutomationControlled"
```

### Verified Run Commands
The following configurations have been tested and verified to pass on Linux machine:

| Browser | Mode | Command Argument | Status |
| :--- | :--- | :--- | :--- |
| **Chrome** | Headless | `-Dselenide.browser=chrome -Dselenide.headless=true -Dchromeoptions.args="--user-agent=...,--disable-blink-features=AutomationControlled"` | ✅ PASSED |
| **Chrome** | Visible | `-Dselenide.browser=chrome -Dselenide.headless=false` | ✅ PASSED |
| **Firefox** | Headless | `-Dselenide.browser=firefox -Dselenide.headless=true` | ✅ PASSED |
| **Firefox** | Visible | `-Dselenide.browser=firefox -Dselenide.headless=false` | ✅ PASSED |
| **Edge** | Headless | `-Dselenide.browser=edge -Dselenide.headless=true -Dedgeoptions.args="--user-agent=...,--disable-blink-features=AutomationControlled"` | 🕒 UNTESTED |
| **Edge** | Visible | `-Dselenide.browser=edge -Dselenide.headless=false` | 🕒 UNTESTED |

> **Notes for Edge & Firefox:**
> - **Windows:** Works out of the box (Edge is default).
> - **Linux:** 
>   - Install `microsoft-edge-stable`.
>   - If automatic driver download fails (Network error), install `msedgedriver` manually and append `-Dwebdriver.edge.driver=/path/to/driver`.
>   - For Firefox, if it fails to locate the driver, append `-Dwebdriver.gecko.driver=$(which geckodriver)`.

---

## 🌍 Multi-Platform Support

| Platform | Support | Notes |
| :--- | :--- | :--- |
| **Windows** | ✅ Full | Supports Chrome, Firefox, and Edge. |
| **Linux** | ✅ Full | Supports Chrome, Firefox, and Edge (if installed). |
| **macOS** | ✅ Full | Supports Chrome, Firefox, Edge, and Safari. |
| **iOS / Android** | ❌ No | Standard Selenide/Selenium is for desktop browsers. Requires **Appium** for mobile. |

---

## 📊 Reports

This project uses Allure for detailed test reporting.

### Standard Workflow (Test + Report)
```bash
./gradlew clean test allureServe
```

### Allure Commands
1.  **Generate and view report locally:**
    ```bash
    ./gradlew allureServe
    ```
2.  **Generate static report:**
    ```bash
    ./gradlew allureReport
    ```
    The report will be available in `build/reports/allure-report/index.html`.

## 📁 Project Structure
- `src/test/java/com/imdb/pages`: Page Object Models.
- `src/test/java/com/imdb/tests`: Test classes and Base configuration.
- `build.gradle`: Project dependencies and configuration.