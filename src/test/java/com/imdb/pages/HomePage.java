package com.imdb.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement acceptCookiesBtn = $("button[data-testid='accept-button']");
    private final SelenideElement categorySelector = $("[data-testid='category-selector-button']");
    private final SelenideElement titlesOption = $x("//li[@role='menuitem' and .//span[text()='Titles']]");
    private final SelenideElement searchInput = $("#suggestion-search");
    private final ElementsCollection suggestions = $$("[data-testid='search-result--const']");

    public void openImdb() {
        open("https://www.imdb.com");
        if (acceptCookiesBtn.is(visible)){
            acceptCookiesBtn.click();
        }
    }

    public void selectTitlesCategory() {
        categorySelector.shouldBe(visible).click();
        titlesOption.shouldBe(visible).click();
    }

    public String searchAndSaveFirstResult(String query) {
        searchInput.shouldBe(visible, Duration.ofSeconds(10)).click();
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.shouldHave(value(query));
        SelenideElement firstResult = suggestions.first().shouldBe(visible);
        String capturedTitle = firstResult.$(".searchResult__constTitle").text();

        firstResult.shouldBe(visible).click();
        return capturedTitle;
    }
}