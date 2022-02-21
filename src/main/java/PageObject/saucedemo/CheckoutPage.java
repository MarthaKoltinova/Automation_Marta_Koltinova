package PageObject.saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By title = By.className("title");

    protected CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());
    }

    public CheckoutPage sendFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckoutPage sendLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage sendZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
        return this;
    }

    public CheckoutPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }

    public void sendInformation(String firstName, String lastName, String zipCode) {
        sendFirstName(firstName).sendLastName(lastName).sendZipCode(zipCode).clickContinueButton();
    }
}
