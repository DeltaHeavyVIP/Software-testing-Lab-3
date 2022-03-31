package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfileData {

    // first name in edit account
    public SelenideElement firstNameInput = $x("//*[@id=\"fname\"]");

    // change button under avatar
    public SelenideElement changePasswordButton = $x("/html/body/main/article/div/div/div/div/div[1]/div/div[2]/ul/li[2]/a");

    // change password
    public SelenideElement oldPasswordInput = $x("//*[@id=\"old_password\"]");
    public SelenideElement newPasswordInput = $x("//*[@id=\"new_password\"]");
    public SelenideElement confirmPasswordInput = $x("//*[@id=\"confirm_password\"]");
    public SelenideElement changePasswordAcceptButton = $x("/html/body/main/article/div/div/div/div/div[2]/div/form/div/div[6]/div/input[5]");

    // side bar
    public SelenideElement accountNameSideBar = $x("//*[@id=\"sidebar\"]/div/div[3]/div[1]/div[2]/a");
    public SelenideElement changeLanguageButtonSideBar  = $x("//*[@id=\"sidebar\"]/div/div[3]/div[3]");
    public SelenideElement russianLanguageSideBar  = $x("//a[contains(text(),'Русский')]");
    public SelenideElement englishLanguageSideBar  = $x("//a[contains(text(),'English')]");

}
