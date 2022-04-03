package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;

public class MainMenu {

    // Icon profile main menu
    public SelenideElement profileButton = $x("/html/body/header/div/div[1]/div");

    // Profile menu
    public SelenideElement userMenu = $x("//*[@id=\"user-menu-1\"]");
    public SelenideElement myAccountButton = $x("//*[@id=\"user-menu-1\"]/li[1]/a");
    public SelenideElement logOutButton = $x("/html/body/div[2]/div/div[5]/div[2]/ul/li[2]/form/button");

    public SelenideElement latestNewsTag = $x("/html/body/header/div/nav/div/ul/li[2]/a");

    // latest news with big image in main menu

    public SelenideElement latestNewsInMainMenu = $x("/html/body/div[4]/div[2]/main/section[1]/div/div[2]/div/div[2]/h3/a");

    // side panel button in main menu
    public SelenideElement sideBarButton = $x("/html/body/header/div/div[1]/button[1]");

    // Learn link in header panel
    public SelenideElement learnTag = $x("//*[@id=\"menu-item-140529\"]/a");
    public SelenideElement tradingText = $x("/html/body/div[4]/div[2]/main/section[2]/div[1]/div[1]/h2"); // CheckLearnTag

    // Learn link in header panel for Russian users
    public SelenideElement ruLearnTag = $x("//*[@id=\"menu-item-11445\"]/a");

    // Opinion link in header panel
    public SelenideElement opinionTag = $x("//*[@id=\"menu-item-96098\"]/a");
    public SelenideElement opinionText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckOpinionText

    // Bitcoin link in header panel
    public SelenideElement bitcoinTag = $x("//*[@id=\"menu-item-90352\"]/a");
    public SelenideElement bitcoinNewsText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckBitcoinTag

    // Altcoin link in header panel
    public SelenideElement altcoinTag = $x("//*[@id=\"menu-item-90353\"]/a");
    public SelenideElement altcoinNewsText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckAltcoinTag

    // Press Releases link in header panel
    public SelenideElement pressReleasesTag = $x("//*[@id=\"menu-item-91935\"]/a");
    public SelenideElement pressReleasesText = $x("/html/body/div[4]/div[2]/main/div[1]/h1/span");// CheckPressReleasesTag
}
