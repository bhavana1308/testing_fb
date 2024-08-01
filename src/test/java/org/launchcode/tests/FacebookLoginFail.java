package org.launchcode.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.launchcode.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLoginFail {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "invalidCredentials")
    public void testInvalidLogin(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorTextDisplayed(), "The error message was not displayed as expected.");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][]{
                {"invalid_user@example.com", "wrongpassword"},
                {"another_invalid@example.com", "123456"}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
