package com.example.selenium_java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {
    private final LoginPage loginPage = new LoginPage();
    private final AdminPanelPage adminPage = new AdminPanelPage();

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void login() throws InterruptedException {
        open("https://telesim.dunice-testing.com/auth/login");
        loginPage.emailArea.sendKeys("operator1@mail.com");
        loginPage.passwordArea.sendKeys("QWEqwe123");
        loginPage.loginButton.click();
        $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[1]/span")).shouldBe(visible);
        assertEquals("https://telesim.dunice-testing.com/staff/dashboard", WebDriverRunner.url());
    }
}

//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.hover();
//
//        $(byClassName("menu-main__popup-wrapper")).shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeAllToolsButton.click();
//
//        $(byClassName("products-list")).shouldBe(visible);
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
//    }

