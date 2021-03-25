package com.example.selenium_java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.codeborne.selenide.Condition.visible;

public class AdminPanelHaveAllSectionsAndTheyWorkedTest {
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
    public void adminPanelHaveAllSectionsAndTheyWorkedTest() throws InterruptedException {
        adminPage.login();
        adminPage.dashboard.shouldBe(visible);
        String dashboardTitile = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
        assertEquals(dashboardTitile, "Dashboard");
        adminPage.accounts.shouldBe(visible);
        adminPage.accounts.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).shouldBe(visible);
        String accountsTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).getText();
        assertEquals(accountsTitle,"App Users");
        adminPage.holdUserList.shouldBe(visible);
        adminPage.holdUserList.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
        String holdTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).getText();
        assertEquals(holdTitle,"Hold user list");
        adminPage.templates.shouldBe(visible);
        adminPage.templates.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
        String templatesTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
        assertEquals(templatesTitle ,"Templates");
        adminPage.packages.shouldBe(visible);
        adminPage.packages.click();
            adminPage.virtualNumbers.shouldBe(visible);
            adminPage.virtualNumbers.click();;
                adminPage.voipPackages.shouldBe(visible);
                adminPage.voipPackages.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
                String voipTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).getText();
                assertEquals(voipTitle,"VoIP Packages");
                adminPage.rates.shouldBe(visible);
                adminPage.rates.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
                String ratesTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).getText();
                assertEquals(ratesTitle,"Rates");
                adminPage.creditPackages.shouldBe(visible);
                adminPage.creditPackages.click();
                $(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div/div[1]/div")).shouldBe(visible);
                String creditTitle = $(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div[2]/div/div[1]/div")).getText();
                assertEquals(creditTitle,"Credit Packages");
            adminPage.translation.shouldBe(visible); //now is not released
            adminPage.eSIM.shouldBe(visible);
            adminPage.eSIM.click();
                adminPage.countryPackages.shouldBe(visible);
                adminPage.countryPackages.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
                String countryTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).getText();
                assertEquals(countryTitle,"Country Packages");
                adminPage.regionPackages.shouldBe(visible);
                adminPage.regionPackages.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
                String regionTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).getText();
                assertEquals(regionTitle,"Region Packages");
                adminPage.subregionPackages.shouldBe(visible);
                adminPage.subregionPackages.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
                String subregionTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).getText();
                assertEquals(subregionTitle,"Subregion Packages");
                adminPage.carriers.shouldBe(visible);
                adminPage.carriers.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]")).shouldBe(visible);
                String carriersTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]")).getText();
                assertEquals(carriersTitle,"Carriers");
                adminPage.plans.shouldBe(visible);
                adminPage.plans.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).shouldBe(visible);
                String plansTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]")).getText();
                assertEquals(plansTitle,"Plans");
                adminPage.directory.shouldBe(visible);
                adminPage.directory.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/span")).shouldBe(visible);
                String directoryURL = WebDriverRunner.url();
                assertEquals(directoryURL,"https://telesim.dunice-testing.com/staff/packages/esim/directory");
                adminPage.profiles.shouldBe(visible);
                adminPage.profiles.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]/h1")).shouldBe(visible);
                String profilesTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
                assertEquals(profilesTitle,"eSIM Profiles");
                adminPage.bundles.shouldBe(visible);
                adminPage.bundles.click();
                $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]/h1")).shouldBe(visible);
                String bundlesTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
                assertEquals(bundlesTitle,"eSIM Bundles");
        adminPage.operators.shouldBe(visible);
        adminPage.operators.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).shouldBe(visible);
        String operatorsTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).getText();
        assertEquals(operatorsTitle,"Operators");
        adminPage.admins.shouldBe(visible);
        adminPage.admins.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).shouldBe(visible);
        String adminsTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).getText();
        assertEquals(adminsTitle,"Admins");
        adminPage.payments.shouldBe(visible);
        adminPage.payments.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
        String paymentsTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
        assertEquals(paymentsTitle,"Payments");
        adminPage.locations.shouldBe(visible);
        adminPage.locations.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
        String locationsTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
        assertEquals(locationsTitle,"Locations");
        adminPage.faq.shouldBe(visible);
        adminPage.faq.click();
            adminPage.faqCategories.shouldBe(visible);
            adminPage.faqCategories.click();
            $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
            String categoriesTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
            assertEquals(categoriesTitle,"Categories");
            adminPage.faqQuestions.shouldBe(visible);
            adminPage.faqQuestions.click();
            $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
            String questionsTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
            assertEquals(questionsTitle,"Questions");
        adminPage.aboutProduct.shouldBe(visible);
        adminPage.aboutProduct.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
        String aboutTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
        assertEquals(aboutTitle,"About product");
        adminPage.supportedDevices.shouldBe(visible);
        adminPage.supportedDevices.click();
            adminPage.devicesBrands.shouldBe(visible);
            adminPage.devicesBrands.click();
            $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
            String brandsTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
            assertEquals(brandsTitle,"Brands");
            adminPage.devicesDevices.shouldBe(visible);
            adminPage.devicesDevices.click();
            $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).shouldBe(visible);
            String devicesTitle = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div[1]")).getText();
            assertEquals(devicesTitle,"Devices");
        adminPage.logout.shouldBe(visible);
    }
}
