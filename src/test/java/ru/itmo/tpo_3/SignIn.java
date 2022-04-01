package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignIn {

    public static final String EMAIL = "sosiskiwteste@mail.ru";
    public static final String PASSWORD = "PTSV7rzu6cV6qsB";
    public static final String ERROR_EMAIL = "fdfdjfjfdjfjf@mail.ru";
    public static final String ERROR_PASSWORD = "PTSV7rzu6cV";

    // Console Sign In
    public SelenideElement consoleSignUpButton = $x("//*[@id=\"bic-login-form\"]/div/div/div[1]/div[1]");

    // Sign In
    public SelenideElement emailSignInInput = $x("//*[@id=\"BICtabLogin\"]/form/div[1]/input");
    public SelenideElement passwordSignInInput = $x("//*[@id=\"BICtabLogin\"]/form/div[2]/input");
    public SelenideElement signInButton = $x("//*[@id=\"BICtabLogin\"]/form/div[5]/button");
    public SelenideElement forgotYourPasswordButton = $x("//*[@id=\"BICtabLogin\"]/div");

    // Forgot password
    public SelenideElement emailForgotPasswordInput = $x("//*[@id=\"BICtabForgot\"]/form/div[1]/input");
    public SelenideElement resetPasswordButton = $x("//*[@id=\"BICtabForgot\"]/form/div[4]/button");
    public SelenideElement backToSignIn = $x("//*[@id=\"BICtabForgot\"]/div");

    // Response: Sign In
    public SelenideElement waitSignInError = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); // Please wait 60 minutes..!
    public SelenideElement unknownPassword = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); //Error: The password you entered for the username sosiski is incorrect. Lost your password?
    public SelenideElement unknownEmail = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); // Unknown email address. Check again or try your username.

    // Response: Forgot password
    public SelenideElement operationForbiddenError = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); // this operation is forbidden
    public SelenideElement invalidEmailAddressError = $x("//*[@id=\"BICtabForgot\"]/form/div[3]/div"); // invalid email or username
    public SelenideElement operationForgotPasswordSuccess = $x("//*[@id=\"BICtabForgot\"]/form/div[2]/div"); // Please check your email

    public void signInSuccess(MainMenu mainMenu){
        mainMenu.profileButton.click();
        emailSignInInput.setValue(SignIn.EMAIL);
        passwordSignInInput.setValue(SignIn.PASSWORD);
        signInButton.click();
    }
}
