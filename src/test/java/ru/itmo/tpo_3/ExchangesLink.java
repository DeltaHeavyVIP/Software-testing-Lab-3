package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;

public class ExchangesLink {

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
}
