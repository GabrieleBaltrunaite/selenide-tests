# selenide-gradle-testng
# IMDb UI Automation

A Selenium/Selenide framework for testing IMDb functionality using **Java 17**, **TestNG**, and **Allure Reports**.

## 🛠 Setup & Requirements
- **Java:** Version 17
- **Gradle:** 8.5+
- **AspectJ Weaver:** Required for Allure steps (configured in `build.gradle`)

## 🚀 Execution
To run the tests:
```bash
./gradlew clean test
```
To view the report locally:
```bash
./gradlew allureServe
```
Press Ctrl+C to terminate the process and return to the terminal.