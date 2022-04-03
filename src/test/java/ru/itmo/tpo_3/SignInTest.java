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
import org.opentest4j.AssertionFailedError;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SignInTest {

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
    public void signInSuccess() {
        signIn.signInSuccess(mainMenu);
        if (profileData.editAccountText.exists()) {
            Assertions.assertEquals("Edit Account", profileData.editAccountText.text());
        } else {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
        }
    }


    @Test
    public void signInErrorPassword() {
        mainMenu.profileButton.click();
        signIn.emailSignInInput.setValue(SignIn.EMAIL);
        signIn.passwordSignInInput.setValue(SignIn.ERROR_PASSWORD);
        signIn.signInButton.click();
        if (signIn.unknownPassword.exists()) {
            Assertions.assertEquals("Error: The password you entered for the email address " + SignIn.EMAIL + " is incorrect. Lost your password?", signIn.unknownPassword.text());
        } else {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
        }
    }

    @Test
    public void signInErrorEmail() {
        mainMenu.profileButton.click();
        signIn.emailSignInInput.setValue(SignIn.ERROR_EMAIL);
        signIn.passwordSignInInput.setValue(SignIn.PASSWORD);
        signIn.signInButton.click();
        if (signIn.unknownEmail.exists()) {
            Assertions.assertEquals("Unknown email address. Check again or try your username.", signIn.unknownEmail.text());
        } else {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
        }

    }

    @Test
    public void forgotPasswordErrorEmail() {
        mainMenu.profileButton.click();
        signIn.forgotYourPasswordButton.click();
        signIn.emailForgotPasswordInput.setValue(SignIn.ERROR_EMAIL);
        signIn.resetPasswordButton.click();
        try {
            Assertions.assertEquals("Invalid email", signIn.invalidEmailAddressError.text());
        } catch (AssertionFailedError e) {
            Assertions.assertEquals("this operation is forbiden", signIn.operationForbiddenError.text());
        }
    }

    @Test
    public void forgotPasswordSuccess() {
        mainMenu.profileButton.click();
        signIn.forgotYourPasswordButton.click();
        signIn.emailForgotPasswordInput.setValue(SignIn.EMAIL);
        signIn.resetPasswordButton.click();
        try {
            Assertions.assertEquals("Please check your email", signIn.operationForgotPasswordSuccess.text());
        } catch (AssertionFailedError e) {
            Assertions.assertEquals("this operation is forbiden", signIn.operationForbiddenError.text());
        }
    }

    //TODO display: none -это главная проблема, но у меня не получается исправить
    @Test
    public void logOut() {
        signIn.signInSuccess(mainMenu);
//        if (profileData.editAccountText.exists()) {
//            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
//        }
        Selenide.sleep(1000);
        mainMenu.sideBarButton.click();
        Selenide.sleep(1000);
        mainMenu.logOutButton.click();
        Selenide.sleep(1000);
        mainMenu.profileButton.click();
        Selenide.sleep(1000);
        Assertions.assertEquals("Sign in", signIn.consoleSignUpButton.text());
    }
}
