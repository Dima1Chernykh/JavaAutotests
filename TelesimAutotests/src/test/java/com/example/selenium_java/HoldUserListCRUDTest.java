package com.example.selenium_java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HoldUserListCRUDTest {

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
    public void createReadUpdateDeleteNewAdminTest() throws InterruptedException {
        adminPage.login();
    }
}
