package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfileMenu {
    public static final String EMAIL = "sosiskiwteste@mail.ru";
    public static final String PASSWORD = "PTSV7rzu6cV6qsB";
    public static final String ERROR_PASSWORD = "PTSV7rzu6cV";

    // Icon profile main menu
    public SelenideElement profileButton = $x("/html/body/header/div/div[1]/div");

    // Console - Sign In
    public SelenideElement emailSignInInput = $x("//*[@id=\"BICtabLogin\"]/form/div[1]/input");
    public SelenideElement passwordSignInInput = $x("//*[@id=\"BICtabLogin\"]/form/div[2]/input");
    public SelenideElement signInButton = $x("//*[@id=\"BICtabLogin\"]/form/div[5]/button");
    public SelenideElement forgotYourPasswordButton = $x("//*[@id=\"BICtabLogin\"]/div");

    // Console - Forgot password
    public SelenideElement emailForgotPasswordInput = $x("//*[@id=\"BICtabForgot\"]/form/div[1]/input");
    public SelenideElement resetPasswordButton = $x("//*[@id=\"BICtabForgot\"]/form/div[4]/button");
    public SelenideElement backToSignIn = $x("//*[@id=\"BICtabForgot\"]/div");

    // Console - Sign Up
    public SelenideElement userNameInput = $x("//*[@id=\"signup-username\"]");
    public SelenideElement firstNameInput = $x("//*[@id=\"signup-first-name\"]");
    public SelenideElement lastNameInput = $x("//*[@id=\"signup-last-name\"]");
    public SelenideElement emailSignUpInput = $x("//*[@id=\"signup-email\"]");
    public SelenideElement passwordSignUpInput = $x("//*[@id=\"signup-password\"]");
    public SelenideElement iAgreeCheckbox = $x("//*[@id=\"BICtabSignUp\"]/form/div[6]/label/input");
    public SelenideElement createAccountButton = $x("//*[@id=\"BICtabSignUp\"]/form/div[9]/button");

    // Response: Console - Sign In
    public SelenideElement waitSignInError = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); // Please wait 60 minutes..!
    public SelenideElement errorText = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); //Error: The password you entered for the username sosiski is incorrect. Lost your password?
    public SelenideElement unknownEmail = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); // Unknown email address. Check again or try your username.

    // Response: Console - Forgot password
    public SelenideElement operationForbiddenError = $x("//*[@id=\"BICtabLogin\"]/form/div[4]/div"); // this operation is forbidden

    // Response: Console - Sign Up
    public SelenideElement successCreateAccount = $x("//*[@id=\"BICtabSignUp\"]/form/div[9]/button");// We have Created an account for you
    public SelenideElement hasAlreadyExistNameAccountError = $x("//*[@id=\"BICtabSignUp\"]/form/div[8]/div"); // User name already exists
    public SelenideElement hasAlreadyExistMailAccountError = $x("//*[@id=\"BICtabSignUp\"]/form/div[8]/div"); // Error Occured please fill up the sign up form carefully

}
