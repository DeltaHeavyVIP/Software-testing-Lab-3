package ru.itmo.tpo_3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SignInTest {

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
    public void signUpSuccess() {

    }


    @Test
    public void signUpError() {

    }
}