package com.example.selenium_java;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement emailArea = $(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[1]/div/input"));
    public SelenideElement passwordArea = $(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[1]/div/input"));
    public SelenideElement loginButton = $("[type=\"button\"]");
}
