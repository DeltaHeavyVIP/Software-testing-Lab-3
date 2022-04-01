package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;

public class MainMenu {

    // Icon profile main menu
    public SelenideElement profileButton = $x("/html/body/header/div/div[1]/div");

    // Profile menu
    public SelenideElement myAccountButton = $x("//*[@id=\"user-menu-1\"]/li[1]/a");
    public SelenideElement logOutButton = $x("//*[@id=\"bic-logout-form\"]/button");

    // latest news with big image in main menu
    public SelenideElement latestNewsInMainMenu = $x("/html/body/div[4]/div[2]/main/section[1]/div/div[2]/div/div[2]/h3/a");

    // side panel button in main menu
    public SelenideElement sideBarButton = $x("/html/body/header/div/div[1]/button[1]");

    // Learn link in header panel
    public SelenideElement learnTag = $x("//*[@id=\"menu-item-140529\"]/a");
    public SelenideElement tradingText = $x("//*[@id=\"menu-item-140529\"]/a"); // CheckLearnTag

    // Learn link in header panel for Russian users
    public SelenideElement ruLearnTag = $x("//*[@id=\"menu-item-11445\"]/a");

    // Latest News link in header panel
    public SelenideElement latestNewsTag = $x("//*[@id=\"menu-item-96097\"]/a");
    public SelenideElement newsText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckLatestNewsTag

    // Opinion link in header panel
    public SelenideElement opinionTag = $x("//*[@id=\"menu-item-96098\"]/a");
    public SelenideElement opinionText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckOpinionText

    // Bitcoin link in header panel
    public SelenideElement bitcoinTag = $x("//*[@id=\"menu-item-90352\"]/a");
    public SelenideElement bitcoinNewsText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckBitcoinTag

    // Altcoin link in header panel
    public SelenideElement altcoinTag = $x("//*[@id=\"menu-item-90353\"]/a");
    public SelenideElement altcoinNewsText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckAltcoinTag

    /*
    Prices link in header panel
    */
    public SelenideElement pricesTag = $x("//*[@id=\"menu-item-73102\"]/a");
    public SelenideElement priceText = $x("//*[@id=\"exchanges-list\"]/div[1]/a[2]");// CheckPricesTag
    // table prices
    public SelenideElement tableCryptoPrice = $x("//*[@id=\"exch-table\"]");
    public SelenideElement sortByPriceButton = $x("//*[@id=\"exch-table\"]/thead/tr/th[4]");
    public SelenideElement firstLinePriceColumn = $x("//*[@id=\"exch-table\"]/tbody/tr[1]/td[4]");
    public SelenideElement sortByMarketCapButton = $x("//*[@id=\"exch-table\"]/thead/tr/th[5]");
    public SelenideElement firstLineMarketCapColumn = $x("//*[@id=\"exch-table\"]/tbody/tr[1]/td[5]");

    /*
    Exchanges link in header panel
    */
    public SelenideElement exchangesTag = $x("//*[@id=\"menu-item-73451\"]/a");
    public SelenideElement exchangesText = $x("//*[@id=\"exchanges-list\"]/div[1]/a[2]");// CheckExchangesTag
    // table exchanges
    public SelenideElement tableCryptoExchanges = $x("//*[@id=\"exch-table\"]");
    public SelenideElement sortBySpreadButton = $x("//*[@id=\"exch-table\"]/thead/tr/th[6]");
    public SelenideElement firstLineSpreadColumn = $x("//*[@id=\"exch-table\"]/tbody/tr[1]/td[6]");

    // method return all filter in exchanges
    public ArrayList<SelenideElement> getExchangesFilterList() {
        ArrayList<SelenideElement> exchangesFilterList = new ArrayList<>();
        String firstPartPathTag = "//*[@id=\"exchanges-list\"]/div[5]/div/div[";
        String secondPartPathTag = "]/div";
        for (int i = 1; i < 11; i++) {
            exchangesFilterList.add($x(firstPartPathTag + i + secondPartPathTag));
        }
        return exchangesFilterList;
    }

    // Press Releases link in header panel
    public SelenideElement pressReleasesTag = $x("//*[@id=\"menu-item-91935\"]/a");
    public SelenideElement pressReleasesText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckPressReleasesTag
}
