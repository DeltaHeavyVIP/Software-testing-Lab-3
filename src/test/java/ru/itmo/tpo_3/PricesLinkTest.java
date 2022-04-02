package ru.itmo.tpo_3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class PricesLinkTest {
    public final PricesLink pricesLink = new PricesLink();

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
    public void checkTableNotEmpty() {
        pricesLink.pricesTag.click();
        Assertions.assertNotNull(pricesLink.tableCryptoPrice.text());
    }

    @Test
    public void checkSortedByMarketCap() {
        pricesLink.pricesTag.click();
        pricesLink.sortByMarketCapButton.click();
        Assertions.assertEquals("$0",  pricesLink.firstLineMarketCapColumn.text());
    }

    //TODO надо как-то по другому проверять эту штуку
    @Test
    public void checkSortedByPrice() {
        pricesLink.pricesTag.click();
        pricesLink.sortByPriceButton.click();
        Assertions.assertEquals("$0",  pricesLink.firstLineMarketCapColumn.text());
    }
}
