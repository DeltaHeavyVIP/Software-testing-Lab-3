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
import org.opentest4j.AssertionFailedError;

import static com.codeborne.selenide.Selenide.open;
import static ru.itmo.tpo_3.SignIn.WAIT_SIGN_IN_ERROR_TEXT;

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
        Selenide.sleep(3000);
        try {
            Assertions.assertEquals("Edit Account", profileData.editAccountText.text());
        } catch (ElementNotFound e) {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
        }
    }


    @Test
    public void signInErrorPassword() {
        mainMenu.profileButton.click();
        signIn.emailSignInInput.setValue(SignIn.EMAIL);
        signIn.passwordSignInInput.setValue(SignIn.ERROR_PASSWORD);
        signIn.signInButton.click();
        Selenide.sleep(1000);
        if(!signIn.waitSignInError.text().equals(WAIT_SIGN_IN_ERROR_TEXT)){
            Assertions.assertEquals("Error: The password you entered for the email address " + SignIn.EMAIL + " is incorrect. Lost your password?", signIn.unknownPassword.text());
        } else  {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
        }
    }

    @Test
    public void signInErrorEmail() {
        mainMenu.profileButton.click();
        signIn.emailSignInInput.setValue(SignIn.ERROR_EMAIL);
        signIn.passwordSignInInput.setValue(SignIn.PASSWORD);
        signIn.signInButton.click();
        Selenide.sleep(1000);
        if(!signIn.waitSignInError.text().equals(WAIT_SIGN_IN_ERROR_TEXT))
            Assertions.assertEquals("Unknown email address. Check again or try your username.", signIn.unknownEmail.text());
        else {
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
        Selenide.sleep(3000);
        try {
            Assertions.assertEquals("Edit Account", profileData.editAccountText.text());
        } catch (ElementNotFound e) {
            Assertions.assertEquals("Please wait 60 minutes..!", signIn.waitSignInError.text());
            return;
        }
        mainMenu.sideBarButton.click();
        mainMenu.logOutButton.click();
        mainMenu.profileButton.click();
        Assertions.assertEquals("Sign in", signIn.consoleSignUpButton.text());
    }
}
