package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;

public class News {

    // share button in news
    public SelenideElement share = $x("/html/body/div[4]/div[2]/main/article/header/div[2]/div[2]/div[1]/div/a");

    // body <div> in news
    public SelenideElement body = $x("/html/body/div[4]/div[2]/main/article/div/div[1]/div[5]/div[1]");

    // author name in news
    public SelenideElement author = $x("/html/body/div[4]/div[2]/main/article/div/div[1]/div[5]/section/div/div[1]/div/div[1]/div[2]/a");

    // method return all tags in news
    public ArrayList<SelenideElement> getNewsTagsList() {
        ArrayList<SelenideElement> newsTagList = new ArrayList<>();
        String firstPartPathTag = "/html/body/div[4]/div[2]/main/article/div/div[1]/div[5]/div[4]/ul/li[";
        String secondPartPathTag = "]/a";
        SelenideElement tag = $x(firstPartPathTag + "1" + secondPartPathTag);
        for (int i = 2; tag.exists(); i++) {
            newsTagList.add(tag);
            tag = $x(firstPartPathTag + i + secondPartPathTag);
        }
        return newsTagList;
    }
}
