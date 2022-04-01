package ru.itmo.tpo_3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainMenuTest {
    public final MainMenu mainMenu = new MainMenu();
    public final LatestNewsLink latestNewsLink = new LatestNewsLink();
    public final PricesLink pricesLink = new PricesLink();
    public final ExchangesLink exchangesLink = new ExchangesLink();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
    }

    @BeforeEach
    public void setUp() {
        open("https://beincrypto.com");
    }

    @Test
    public void checkLearnTag() {
        mainMenu.learnTag.click();
        Assertions.assertEquals("Trending Now \uD83D\uDD25", mainMenu.tradingText.text());
    }

    @Test
    public void checkLatestNewsTag() {
        latestNewsLink.latestNewsTag.click();
        Assertions.assertEquals("NEWS", latestNewsLink.newsText.text());
    }

    @Test
    public void checkOpinionTag() {
        mainMenu.opinionTag.click();
        Assertions.assertEquals("OPINION", mainMenu.opinionText.text());
    }

    @Test
    public void checkBitcoinTag() {
        mainMenu.bitcoinTag.click();
        Assertions.assertEquals("BITCOIN NEWS", mainMenu.bitcoinNewsText.text());
    }

    @Test
    public void checkAltcoinTag() {
        mainMenu.altcoinTag.click();
        Assertions.assertEquals("ALTCOIN NEWS", mainMenu.altcoinNewsText.text());
    }

    @Test
    public void checkPricesTag() {
        pricesLink.pricesTag.click();
        Assertions.assertEquals("Price", pricesLink.priceText.text());
    }

    @Test
    public void checkExchangesTag() {
        exchangesLink.exchangesTag.click();
        Assertions.assertEquals("Exchanges", exchangesLink.exchangesText.text());
    }

    @Test
    public void checkPressReleasesTag() {
        mainMenu.pressReleasesTag.click();
        Assertions.assertEquals("PRESS RELEASES", mainMenu.pressReleasesText.text());
    }
}
