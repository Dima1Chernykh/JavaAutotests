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
        adminPage.createAndChooseNewAccount();
//        String fullName = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[1]/div[3]/div/div/div[3]/form/div[1]/div/div[1]/div/input"))
//                .getAttribute("value");
        SelenideElement onHoldButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[2]/div[1]/div[2]/button[2]/span/img"));
        onHoldButton.click();
        SelenideElement onHoldTextArea = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/form/div/div[1]/div/div[1]/div/textarea"));
        onHoldTextArea.sendKeys(adminPage.generateRandomHexString(8));
        String saveOnHoldTextArea = onHoldTextArea.getAttribute("value");
        String holdUserListCountString = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[3]/div[2]/div")).getText();
        int holdUserListCount = Integer.parseInt(holdUserListCountString);
        SelenideElement sendButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/form/div/div[2]/button"));
        sendButton.click();
        $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[3]/div[2]/div"));
        Thread.sleep(2000);
        String holdUserListCountStringNew = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[3]/div[2]/div")).getText();
        int holdUserListCountNew = Integer.parseInt(holdUserListCountStringNew);
        String fullName = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div")).getText();
        String fullNameForAssert = fullName.substring(0, 1).toUpperCase(Locale.ROOT) + fullName.substring(1);
        assertEquals($(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/div[2]/p"))
                .getText(), saveOnHoldTextArea);
        assertEquals(holdUserListCountNew, holdUserListCount + 1);
        SelenideElement backButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/button/span"));
        backButton.click();
        adminPage.holdUserList.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
        SelenideElement searchHoldInput = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[2]/div[1]/div/input"));
        searchHoldInput.sendKeys(fullName);
        Thread.sleep(2000);
        assertEquals($(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div/div[1]/table/tbody/tr/td[2]/span[1]")).getText(), fullNameForAssert);
        SelenideElement goToUser = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div/div[1]/table/tbody/tr/td[2]/span[1]"));
        goToUser.click();
        SelenideElement deleteButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[1]/div[2]/div/div[5]"));
        deleteButton.click();
        SelenideElement confirmDeleteButton = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/button[1]/span"));
        confirmDeleteButton.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[2]/img")).should(disappear);
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).should(exist);
        String pagination = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[2]/div/div[2]/div[1]")).getText();
        assertEquals(pagination, "0 of 0 users");
    }
}
