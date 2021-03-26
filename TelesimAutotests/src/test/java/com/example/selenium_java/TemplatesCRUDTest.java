package com.example.selenium_java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplatesCRUDTest {
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
        adminPage.templates.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
        SelenideElement createTemplateButton = $(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[1]/button"));
        createTemplateButton.click();
        SelenideElement subjectInput = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/form/div[1]/div/div[1]/div/input"));
        SelenideElement htmlCodeInput = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/form/div[2]/div/div[1]/div/textarea"));
        SelenideElement inactiveCheck = $(By.className("v-input--selection-controls__ripple"));
        String subject = adminPage.generateRandomHexString(8);
        String htmlCode = adminPage.generateRandomHexString(10);
        subjectInput.sendKeys(subject);
        String subjectInputText = subjectInput.getAttribute("value");
        htmlCodeInput.sendKeys(htmlCode);
        String htmlCodeInputText = htmlCodeInput.getAttribute("value");
        inactiveCheck.click();
        SelenideElement addTemplate = $(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[3]/button"));
        addTemplate.click();
        SelenideElement searchInput = $(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div/div[2]/input"));
        searchInput.sendKeys(subjectInputText);
        Thread.sleep(1000);
        assertEquals($(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/span")).getText(), subjectInputText);
        assertEquals($(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/span")).getText(), "Active");
        SelenideElement newTemplateOptions = $(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[5]/button"));
        newTemplateOptions.click();
        SelenideElement newTemplateEdit = $(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]"));
        newTemplateEdit.click();
        SelenideElement editSubjectInput = $(By.cssSelector("input[type='text']"));
//        editSubjectInput.sendKeys(Keys.DELETE);
        // implement Update
        editSubjectInput.sendKeys("qwe");
        String newSubjectInputText = editSubjectInput.getAttribute("value");
        SelenideElement editHtmlCodeInput = $(By.xpath("textarea[rows='10']"));
//        editHtmlCodeInput.sendKeys(Keys.DELETE);
        editHtmlCodeInput.sendKeys(htmlCode);
        String newHtmlCodeInputText = editHtmlCodeInput.getAttribute("value");
        inactiveCheck.click();
        SelenideElement saveButton = $(By.xpath("/html/body/div[1]/div/div[5]/div/div/div[3]/button[1]"));
        saveButton.click();
        searchInput.sendKeys(newSubjectInputText);
        assertEquals($(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/span")).getText(), newSubjectInputText);
        assertEquals($(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[4]/span")).getText(), "Inactive");
        newTemplateOptions.click();
        SelenideElement removeButton = $(By.xpath("/html/body/div[1]/div/div[3]/div/div[4]"));
        removeButton.click();
        SelenideElement deleteButton = $(By.xpath("/html/body/div[1]/div/div[6]/div/div/div[2]/button[1]"));
        deleteButton.click();
        String pagination = $(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div[2]/div[2]/div[2]/div[1]")).getText();
        assertEquals(pagination, "0 of 0 templates");
    }
}
