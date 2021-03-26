package com.example.selenium_java;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.Random;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// login method
public class AdminPanelPage {
    public void login() throws InterruptedException {
        open("https://telesim.dunice-testing.com/auth/login");
        LoginPage loginPage = new LoginPage();
        loginPage.emailArea.sendKeys("user2@mail.com");
        loginPage.passwordArea.sendKeys("QWEqwe123");
        loginPage.loginButton.click();
        $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[1]/span")).shouldBe(visible);
    }
    // sections
    public SelenideElement dashboard  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[1]/div[2]"));
    public SelenideElement accounts  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[2]/div[2]"));
    public SelenideElement holdUserList  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[3]/div[2]"));
    public SelenideElement templates  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[4]/div[2]"));
    public SelenideElement packages  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div/div/span"));
        public SelenideElement virtualNumbers = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[1]/div/span"));
            public SelenideElement voipPackages = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a"));
            public SelenideElement rates = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/a"));
            public SelenideElement creditPackages = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/a"));
        public SelenideElement translation = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[2]/a"));
        public SelenideElement eSIM = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div"));
            public SelenideElement countryPackages = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[1]"));
            public SelenideElement regionPackages = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]"));
            public SelenideElement subregionPackages = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[3]"));
            public SelenideElement carriers = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[4]/a"));
            public SelenideElement plans = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[5]/a"));
            public SelenideElement directory = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[6]/a"));
            public SelenideElement profiles = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[7]/a"));
            public SelenideElement bundles = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[8]/a"));
    public SelenideElement operators  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[5]/div[2]"));
    public SelenideElement admins  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[6]/div[2]"));
    public SelenideElement payments  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[7]/div[2]"));
    public SelenideElement locations = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[8]/div[2]"));
    public SelenideElement faq  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[2]/div"));
        public SelenideElement faqCategories = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[2]/div[2]/div[1]/a"));
        public SelenideElement faqQuestions = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[2]/div[2]/div[2]/a"));
    public SelenideElement aboutProduct  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/a[9]/div[2]"));
    public SelenideElement supportedDevices  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[3]/div/div"));
        public SelenideElement devicesBrands = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[3]/div[2]/div[1]/a"));
        public SelenideElement devicesDevices = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[3]/div[2]/div[2]/a"));
    public SelenideElement logout  = $(By.xpath("/html/body/div[1]/div/div/div/nav/div[1]/div[2]/div[4]/div[2]"));

    // random string generation
    public static String generateRandomHexString (int length){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < length){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, length);
    }
    public static void createAndChooseNewAccount () throws InterruptedException {
        AdminPanelPage adminPage = new AdminPanelPage();
        adminPage.accounts.shouldBe(visible);
        adminPage.accounts.click();
        $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[1]")).shouldBe(visible);
        SelenideElement createUserButton = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[1]/div[2]/div[5]"));
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
        SelenideElement newUser = $(By.xpath("/html/body/div[1]/div/div/div/main/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[2]/span[1]"));
        newUser.click();
    }
}
