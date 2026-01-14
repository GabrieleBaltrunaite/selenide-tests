package com.imdb.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TitlePage {
    private final SelenideElement movieTitle = $("[data-testid='hero__primary-text']");
    private final ElementsCollection castList = $$("[data-testid='title-cast-item']");

    public void verifyPageHeader(String expectedTitle) {
        movieTitle.shouldHave(text(expectedTitle), Duration.ofSeconds(10));
    }

    public void verifyCastCountAtLeast(int count) {
        castList.shouldHave(sizeGreaterThanOrEqual(count));
    }

    public String clickCastMember(int index) {
        SelenideElement actorLink = castList.get(index).$("[data-testid='title-cast-item__actor']");

        actorLink.should(exist, Duration.ofSeconds(10));
        actorLink.scrollIntoView("{block: \"center\", inline: \"center\"}");
        String actorName = actorLink.text();
        actorLink.click(ClickOptions.usingJavaScript());

        return actorName;
    }
}