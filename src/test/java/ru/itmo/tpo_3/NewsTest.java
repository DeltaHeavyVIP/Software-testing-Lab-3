package ru.itmo.tpo_3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;

public class NewsTest {
    public final MainMenu mainMenu = new MainMenu();
    public final News news = new News();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.timeout = 60000;
    }

    @BeforeEach
    public void setUp() {
        open("https://beincrypto.com");
    }

    @Test
    public void checkNewsHeadlinesInMainMenu() {
        Assertions.assertNotNull(mainMenu.latestNewsInMainMenu.text());
    }

    @Test
    public void checkBodyNews() {
        mainMenu.latestNewsInMainMenu.click();
        Assertions.assertNotNull(news.body.text());
    }

    @Test
    public void checkShareNews() {
        mainMenu.latestNewsInMainMenu.click();
        news.share.click();
        Assertions.assertNotNull(news.checkShareArticle.text());
    }

    @Test
    public void checkAuthorNews() {
        mainMenu.latestNewsInMainMenu.click();
        Assertions.assertNotNull(news.author.text());
    }

    @Test
    public void checkTagsNews() {
        mainMenu.latestNewsInMainMenu.click();
        ArrayList<SelenideElement> arrayTag = news.getNewsTagsList();
        for (int i = 0; i < arrayTag.size(); i++) {
            String tagName = arrayTag.get(i).text().toUpperCase();
            arrayTag.get(i).click();
            System.out.println("CHECK TAG " + (i + 1) + " ...");
            Assertions.assertEquals(tagName, news.checkTags.text());
            System.out.println("CHECK TAG " + (i + 1) + " SUCCESS");
            back();
        }
    }
}
