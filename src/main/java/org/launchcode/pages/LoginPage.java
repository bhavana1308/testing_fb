package org.launchcode.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;


    private final By emailField = By.id("email");
    private final By passwordField = By.id("pass");
    private final By loginButton = By.name("login");
    private final By errorText = By.xpath("//div[@id='email_container']//div[contains(text(), 'The email address you entered')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorTextDisplayed() {
        WebElement errorElement = driver.findElement(errorText);
        return errorElement.isDisplayed();
    }

}

