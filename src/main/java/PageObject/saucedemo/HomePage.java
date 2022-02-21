package PageObject.saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {
    private By login = By.name("user-name");
    private By passwordHomePage = By.id("password");
    private By loginButton = By.name("login-button");
    private  By logo=By.className("login_logo");


    public void sendUserName(String username) {
        driver.findElement(login).sendKeys(username);
    }

    public void sendPassword(String password) {
        driver.findElement(passwordHomePage).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void logIn(String username, String password) {
        sendUserName(username);
        sendPassword(password);
        clickLoginButton();

    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(logo).isDisplayed());
    }

}
