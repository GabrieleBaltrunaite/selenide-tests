package com.imdb.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeSuite
    public void setupAllure() {
        // This attaches screenshots and page source to Allure reports automatically on failure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @BeforeMethod
    public void configuration() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000; // 10 seconds for stable element finding
        Configuration.headless = false; // Set to true for CI/CD pipelines or to avoid interference
    }
}