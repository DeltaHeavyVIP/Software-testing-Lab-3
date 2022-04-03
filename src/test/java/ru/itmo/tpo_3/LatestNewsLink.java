package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LatestNewsLink {

    // Latest News link in header panel
    public SelenideElement latestNewsTag = $x("//*[@id=\"menu-item-96097\"]/a");
    public SelenideElement newsText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckLatestNewsTag

    public SelenideElement firstNews = $x("/html/body/div[4]/div[2]/main/div[2]/article[1]/div[2]/h3/a");
}
