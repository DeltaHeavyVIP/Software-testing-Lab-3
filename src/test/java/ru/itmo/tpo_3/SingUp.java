package ru.itmo.tpo_3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SingUp {

    public static final String USERNAME = "wwwwwwww";
    public static final String FIRST_NAME = "wwwwwwww";
    public static final String LAST_NAME = "wwwwwwww";
    public static final String EMAIL_ADDRESS = "wwwwwwww@mail.ru";
    public static final String PASSWORD = "GF3h4gCWNxCQ8Rr";
    public static final String EXIST_EMAIL_ADDRESS = "sosiskiwteste@mail.ru";
    public static final String EXIST_USERNAME = "sosiski";


    // Console Sign Up
    public SelenideElement consoleSignUpButton = $x("//*[@id=\"bic-login-form\"]/div/div/div[1]/div[2]");

    // Sign Up
    public SelenideElement userNameInput = $x("//*[@id=\"signup-username\"]");
    public SelenideElement firstNameInput = $x("//*[@id=\"signup-first-name\"]");
    public SelenideElement lastNameInput = $x("//*[@id=\"signup-last-name\"]");
    public SelenideElement emailSignUpInput = $x("//*[@id=\"signup-email\"]");
    public SelenideElement passwordSignUpInput = $x("//*[@id=\"signup-password\"]");
    public SelenideElement iAgreeCheckbox = $x("//*[@id=\"BICtabSignUp\"]/form/div[6]/label/input");
    public SelenideElement createAccountButton = $x("//*[@id=\"BICtabSignUp\"]/form/div[9]/button");

    // Response: Sign Up
    public SelenideElement successCreateAccount = $x("//*[@id=\"BICtabSignUp\"]/form/div[9]/button");// We have Created an account for you
    public SelenideElement hasAlreadyExistNameAccountError = $x("//*[@id=\"BICtabSignUp\"]/form/div[8]/div"); // User name already exists
    public SelenideElement hasAlreadyExistMailAccountError = $x("//*[@id=\"BICtabSignUp\"]/form/div[8]/div"); // Error Occured please fill up the sign up form carefully
}
