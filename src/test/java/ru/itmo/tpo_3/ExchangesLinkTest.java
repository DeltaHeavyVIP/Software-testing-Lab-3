package ru.itmo.tpo_3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

public class ExchangesLinkTest {
    public final ExchangesLink exchangesLink = new ExchangesLink();

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
    public void checkTableNotEmpty() {
        exchangesLink.exchangesTag.click();
        Assertions.assertNotNull(exchangesLink.tableCryptoExchanges.text());
    }

    @Test
    public void checkSortBySpread() {
        exchangesLink.exchangesTag.click();
        exchangesLink.sortBySpreadButton.click();
        Selenide.sleep(3000);
        Assertions.assertEquals("Vebitcoin\nCentralized", exchangesLink.firstLineExchangeColumn.text());
    }

    @Test
    public void checkFilters() {
        exchangesLink.exchangesTag.click();
        ArrayList<SelenideElement> arrayFilters = exchangesLink.getExchangesFilterList();
        Assertions.assertTrue(exchangesLink.OKXLine.exists());
        arrayFilters.get(2).click();
        Selenide.sleep(1000);
        Assertions.assertFalse(exchangesLink.OKXLine.exists());
    }

    @Test
    public void checkWithdrawalFees() {
        exchangesLink.exchangesTag.click();
        exchangesLink.secondLineExchangeColumn.click();
        exchangesLink.withdrawalFeesButton.click();
        Assertions.assertNotNull(exchangesLink.withdrawalFeesTable.text());
    }

    @Test
    public void checkTradingFees() {
        exchangesLink.exchangesTag.click();
        exchangesLink.secondLineExchangeColumn.click();
        exchangesLink.tradingFeesButton.click();
        Assertions.assertNotNull(exchangesLink.tradingFeesTable.text());
    }

    @Test
    public void checkMarkets() {
        exchangesLink.exchangesTag.click();
        exchangesLink.secondLineExchangeColumn.click();
        exchangesLink.marketsButton.click();
        Assertions.assertNotNull(exchangesLink.marketsTable.text());
    }
}
