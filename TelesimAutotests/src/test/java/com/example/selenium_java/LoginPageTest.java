package com.example.selenium_java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void login() {
        open("https://telesim.dunice-testing.com/auth/login");
        loginPage.emailArea.sendKeys("operator1@mail.com");
        loginPage.passwordArea.sendKeys("QWEqwe123");
        loginPage.loginButton.click();
        $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[1]/span")).shouldBe(visible);
        assertEquals("https://telesim.dunice-testing.com/staff/dashboard", WebDriverRunner.url());
    }
}

