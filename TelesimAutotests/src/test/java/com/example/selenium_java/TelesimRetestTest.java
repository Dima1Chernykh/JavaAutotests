package com.example.selenium_java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Locale;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelesimRetestTest {
    private final LoginPage loginPage = new LoginPage();
    private final AdminPanelPage adminPage = new AdminPanelPage();

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
        open("https://telesim.dunice-testing.com/auth/login");
    }

    @Test
    public void addCountryToNewRegion() throws InterruptedException {
        loginPage.emailArea.sendKeys("operator1@mail.com");
        loginPage.passwordArea.sendKeys("QWEqwe123");
        loginPage.loginButton.click();
        Thread.sleep(2000);
        adminPage.locations.click();
        SelenideElement regions = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[3]"));
        regions.click();
        Thread.sleep(1000);
        SelenideElement createRegionButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/div[2]"));
        createRegionButton.click();
        SelenideElement regionTitle = $(By.cssSelector("[placeholder='Title']"));
        regionTitle.sendKeys(adminPage.generateRandomHexString(8));
        String randomRegionTitleText = regionTitle.getAttribute("value").substring(0, 1).toUpperCase(Locale.ROOT) + regionTitle.getAttribute("value").substring(1);
        Thread.sleep(1000);
        SelenideElement addCountryButton = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div[2]/div/div/div/div[4]/div[2]/div[1]/button/span"));
        addCountryButton.click();
        Thread.sleep(1000);
        SelenideElement addCountry = $(By.xpath("/html/body/div[1]/div/div[5]/div/div/div[3]/div[2]/div/div[2]/div/div[1]/div/div[1]"));
        addCountry.click();
        Thread.sleep(1000);
        SelenideElement saveCountryButton = $(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[4]"));
        saveCountryButton.click();
        Thread.sleep(1000);
        SelenideElement addRegionButton = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div[2]/div/div/div/div[5]"));
        addRegionButton.click();
        Thread.sleep(1000);
        SelenideElement dateOrder = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/table/thead/tr/th[2]"));
        dateOrder.click();
        dateOrder.click();
        Thread.sleep(1000);
        SelenideElement newRegion = $(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[1]/div/span"));
        String newRegionText = newRegion.text();
        assertEquals(randomRegionTitleText, newRegionText);
    }
}
