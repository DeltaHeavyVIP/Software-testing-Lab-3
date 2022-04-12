package ru.itmo.tpo_3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ProfileDataTest {
    public final MainMenu mainMenu = new MainMenu();
    public final SignIn signIn = new SignIn();
    public final ProfileData profileData = new ProfileData();

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
    public void changeName() {
        signIn.signInSuccess(mainMenu);
        Selenide.sleep(3000);
        try {
            Assertions.assertEquals("Edit Account", profileData.editAccountText.text());
        } catch (ElementNotFound e) {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
            return;
        }
        String changeName = profileData.generateFirsteName();
        profileData.firstNameInput.setValue(changeName);
        profileData.submitChangesButton.click();
        Assertions.assertEquals("You have successfully edited your account details", profileData.changesApplied.text());
    }

    @Test
    public void changePassword() {
        signIn.signInSuccess(mainMenu);
        Selenide.sleep(3000);
        try {
            Assertions.assertEquals("Edit Account", profileData.editAccountText.text());
        } catch (ElementNotFound e) {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
            return;
        }
        profileData.changePasswordButton.click();
        profileData.oldPasswordInput.setValue(SignIn.PASSWORD);
        profileData.newPasswordInput.setValue(SignIn.PASSWORD);
        profileData.confirmPasswordInput.setValue(SignIn.PASSWORD);
        profileData.changePasswordAcceptButton.click();
        Assertions.assertEquals("You have successfully changed your password", profileData.changePasswordApplied.text());
    }

    @Test
    public void changeLanguage() {
        mainMenu.sideBarButton.click();
        profileData.changeLanguageButtonSideBar.click();
        profileData.russianLanguageSideBar.click();
        Assertions.assertEquals("Новости", mainMenu.ruLearnTag.text());
    }
}
