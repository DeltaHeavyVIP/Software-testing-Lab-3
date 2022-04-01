package ru.itmo.tpo_3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        mainMenu.profileButton.click();
        signIn.emailSignInInput.setValue(SignIn.EMAIL);
        signIn.passwordSignInInput.setValue(SignIn.PASSWORD);
        signIn.signInButton.click();
        Assertions.assertEquals("Edit Account", profileData.editAccountText.text());
    }


    @Test
    public void signInErrorPassword() {
        mainMenu.profileButton.click();
        signIn.emailSignInInput.setValue(SignIn.EMAIL);
        signIn.passwordSignInInput.setValue(SignIn.ERROR_PASSWORD);
        signIn.signInButton.click();
        Assertions.assertEquals("Error: The password you entered for the email address " + SignIn.EMAIL + " is incorrect. Lost your password?", signIn.unknownPassword.text());
    }

    @Test
    public void signInErrorEmail() {
        mainMenu.profileButton.click();
        signIn.emailSignInInput.setValue(SignIn.ERROR_EMAIL);
        signIn.passwordSignInInput.setValue(SignIn.PASSWORD);
        signIn.signInButton.click();
        Assertions.assertEquals("Unknown email address. Check again or try your username.", signIn.unknownEmail.text());
    }

    @Test
    public void forgotPasswordErrorEmail() {
        mainMenu.profileButton.click();
        signIn.forgotYourPasswordButton.click();
        signIn.emailForgotPasswordInput.setValue(SignIn.ERROR_EMAIL);
        signIn.resetPasswordButton.click();
        Assertions.assertEquals("Invalid email", signIn.invalidEmailAddressError.text());
    }

    @Test
    public void forgotPasswordSuccess() {
        mainMenu.profileButton.click();
        signIn.forgotYourPasswordButton.click();
        signIn.emailForgotPasswordInput.setValue(SignIn.EMAIL);
        signIn.resetPasswordButton.click();
        Assertions.assertEquals("Please check your email", signIn.operationForgotPasswordSuccess.text());
    }
}
