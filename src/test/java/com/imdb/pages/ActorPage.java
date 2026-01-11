package com.imdb.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ActorPage {
    private final SelenideElement actorNameHeader = $("h1 [data-testid='hero__primary-text']");
    public void verifyProfileName(String expectedName) {
        actorNameHeader.shouldHave(text(expectedName));
    }
}
