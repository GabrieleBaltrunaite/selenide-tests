package com.imdb.tests;

import com.imdb.pages.ActorPage;
import com.imdb.pages.HomePage;
import com.imdb.pages.TitlePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ImdbSearchTest extends BaseTest {
    HomePage homePage = new HomePage();
    TitlePage titlePage = new TitlePage();
    ActorPage actorPage = new ActorPage();

    @Description("Verify home page title search suggestions and cast member navigation")
    @Test
    public void testImdbSearchAndCastMemberView() {

        homePage.openImdb();
        homePage.selectTitlesCategory();
        String savedTitle = homePage.searchAndSaveFirstResult("QA");
        titlePage.verifyPageHeader(savedTitle);
        titlePage.verifyCastCountAtLeast(3);
        String savedActorName = titlePage.clickCastMember(2);
        actorPage.verifyProfileName(savedActorName);
    }
}