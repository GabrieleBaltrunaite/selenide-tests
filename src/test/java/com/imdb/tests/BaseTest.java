package com.imdb.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeSuite
    public void setupAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @BeforeMethod
    public void configuration() {
        Configuration.browser = System.getProperty("selenide.browser", "chrome");
        Configuration.browserSize = System.getProperty("selenide.browserSize", "1920x1080");
        Configuration.timeout = Long.parseLong(System.getProperty("selenide.timeout", "10000"));
        Configuration.headless = Boolean.parseBoolean(System.getProperty("selenide.headless", "false"));
    }
}