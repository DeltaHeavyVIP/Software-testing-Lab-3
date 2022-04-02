package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PricesLink {

    public SelenideElement pricesTag = $x("//*[@id=\"menu-item-73102\"]/a");
    public SelenideElement priceText = $x("//*[@id=\"exchanges-list\"]/div[1]/a[2]");// CheckPricesTag
    // table prices
    public SelenideElement tableCryptoPrice = $x("//*[@id=\"exch-table\"]");
    public SelenideElement sortByPriceButton = $x("//*[@id=\"exch-table\"]/thead/tr/th[4]");
    public SelenideElement firstLinePriceColumn = $x("//*[@id=\"exch-table\"]/tbody/tr[1]/td[4]");
    public SelenideElement sortByMarketCapButton = $x("//*[@id=\"exch-table\"]/thead/tr/th[5]");
    public SelenideElement firstLineMarketCapColumn = $x("//*[@id=\"exch-table\"]/tbody/tr[1]/td[5]");

}
