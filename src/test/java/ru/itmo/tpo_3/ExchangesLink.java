package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;

public class ExchangesLink {

    public SelenideElement exchangesTag = $x("//*[@id=\"menu-item-73451\"]/a");
    public SelenideElement exchangesText = $x("//*[@id=\"exchanges-list\"]/div[1]/a[2]");// CheckExchangesTag
    // table exchanges
    public SelenideElement tableCryptoExchanges = $x("//*[@id=\"exch-table\"]");
    public SelenideElement sortBySpreadButton = $x("//*[@id=\"exch-table\"]/thead/tr/th[6]");
    public SelenideElement firstLineRatingColumn = $x("//*[@id=\"exch-table\"]/tbody/tr[1]/td[3]/span");
    public SelenideElement OKXLine = $x("//strong[contains(.,'OKX')]");
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

    // first element in table
    public SelenideElement firstLineExchangeColumn = $x("//*[@id=\"exch-table\"]/tbody/tr[1]/td[2]/a/p[2]");

    // line with link
    public SelenideElement marketsButton = $x("//*[@id=\"exchange-one\"]/div[5]/div[1]/div[1]");
    public SelenideElement tradingFeesButton = $x("//*[@id=\"exchange-one\"]/div[5]/div[1]/div[3]");
    public SelenideElement withdrawalFeesButton = $x("//*[@id=\"exchange-one\"]/div[5]/div[1]/div[4]");

    // table
    public SelenideElement marketsTable = $x("//*[@id=\"exchange-one\"]/div[5]/div[2]/div[1]/div[1]/table");
    public SelenideElement tradingFeesTable = $x("//*[@id=\"exchange-one\"]/div[5]/div[2]/div[3]/table");
    public SelenideElement withdrawalFeesTable = $x("//*[@id=\"exchange-one\"]/div[5]/div[2]/div[4]/table");

}
