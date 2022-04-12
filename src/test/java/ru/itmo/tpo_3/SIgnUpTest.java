package ru.itmo.tpo_3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class SIgnUpTest {
    public final MainMenu mainMenu = new MainMenu();
    public final SingUp singUp = new SingUp();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.timeout = 60000;
    }

    @BeforeEach
    public void setUp() {
        open("https://beincrypto.com");
    }

    @Disabled
    @Test
    public void signUpSuccess() {
        mainMenu.profileButton.click();
        singUp.consoleSignUpButton.click();
        singUp.userNameInput.setValue(SingUp.USERNAME);
        singUp.firstNameInput.setValue(SingUp.FIRST_NAME);
        singUp.lastNameInput.setValue(SingUp.LAST_NAME);
        singUp.emailSignUpInput.setValue(SingUp.EMAIL_ADDRESS);
        singUp.passwordSignUpInput.setValue(SingUp.PASSWORD);
        singUp.iAgreeCheckbox.click();
        singUp.createAccountButton.click();
        Assertions.assertEquals("We have Created an account for you", singUp.successCreateAccount.text());
    }

    @Test
    public void signUpAlreadyExistNameAccountError() {
        mainMenu.profileButton.click();
        singUp.consoleSignUpButton.click();
        singUp.userNameInput.setValue(SingUp.EXIST_USERNAME);
        singUp.firstNameInput.setValue(SingUp.FIRST_NAME);
        singUp.lastNameInput.setValue(SingUp.LAST_NAME);
        singUp.emailSignUpInput.setValue(SingUp.EMAIL_ADDRESS);
        singUp.passwordSignUpInput.setValue(SingUp.PASSWORD);
        singUp.iAgreeCheckbox.click();
        singUp.createAccountButton.click();
        Assertions.assertEquals("User name already exixts", singUp.hasAlreadyExistNameAccountError.text());
    }

    @Test
    public void signUpAlreadyExistMailAccountError() {
        mainMenu.profileButton.click();
        singUp.consoleSignUpButton.click();
        singUp.userNameInput.setValue(SingUp.USERNAME);
        singUp.firstNameInput.setValue(SingUp.FIRST_NAME);
        singUp.lastNameInput.setValue(SingUp.LAST_NAME);
        singUp.emailSignUpInput.setValue(SingUp.EXIST_EMAIL_ADDRESS);
        singUp.passwordSignUpInput.setValue(SingUp.PASSWORD);
        singUp.iAgreeCheckbox.click();
        singUp.createAccountButton.click();
        Assertions.assertEquals("Error Occured please fill up the sign up form carefully", singUp.hasAlreadyExistNameAccountError.text());
    }
}
