package com.example.selenium_java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateReadUpdateDeleteNewAdminTest {
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
        adminPage.accounts.shouldBe(visible);
        adminPage.admins.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).shouldBe(visible);
        SelenideElement createUserButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[2]/div[4]"));
        createUserButton.click();
        String fullName = adminPage.generateRandomHexString(8);
        String email = adminPage.generateRandomHexString(5) + "@gmail.com";
        String password = "A" +  adminPage.generateRandomHexString(9);
        SelenideElement fullNameInput = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[3]/span/div[1]/div/div/div[1]/div/input"));
        SelenideElement emailInput = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[3]/span/div[2]/div/div/div[1]/div/input"));
        SelenideElement passwordInput = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[3]/span/div[5]/div/div/div[1]/div/input"));
        SelenideElement confirmPasswordInput = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[3]/span/div[6]/div/div/div[1]/div/input"));
        fullNameInput.sendKeys(fullName);
        String randomFullname = fullNameInput.getAttribute("value");
        emailInput.sendKeys(email);
        String randomEmail = emailInput.getAttribute("value");
        passwordInput.sendKeys(password);
        String randomPassword = passwordInput.getAttribute("value");
        confirmPasswordInput.sendKeys(randomPassword);
        SelenideElement confirmButton = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[4]/div[1]"));
        confirmButton.click();
        SelenideElement searchInput = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[2]/div[1]/div/input"));
        searchInput.sendKeys(randomFullname);
        Thread.sleep(1000);
        String randomNameForAssert = randomFullname.substring(0, 1).toUpperCase(Locale.ROOT) + randomFullname.substring(1);
        assertEquals(($(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[2]/span")).getText()), randomNameForAssert);
        assertEquals(($(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[6]/span")).getText()), "Active");
        SelenideElement newUser = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[2]"));
        newUser.click();
//        SelenideElement activeButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]"));
//        activeButton.click();
        SelenideElement backButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/button/span"));
//        backButton.click();
//        assertEquals(($(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[8]/span")).getText()), "Verified");
//        newUser.click();
        SelenideElement blockButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/div[1]"));
        blockButton.click();
        backButton.click();
        assertEquals(($(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[6]/span")).getText()), "Blocked");
        newUser.click();
        SelenideElement deleteButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[1]/div[2]/div/div[5]"));
        deleteButton.click();
        SelenideElement confirmDeleteButton = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/button[1]/span"));
        confirmDeleteButton.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[2]/img")).should(disappear);
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).should(exist);
        String pagination = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[2]/div[2]/div[1]")).getText();
        assertEquals(pagination, "0 of 0 admins");
    }
}