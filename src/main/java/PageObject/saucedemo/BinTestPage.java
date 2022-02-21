package PageObject.saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BinTestPage extends BasePage {
    private By removeButton = By.name("remove-sauce-labs-backpack");
    private By checkoutButton = By.id("checkout");
    private By removedItem = By.className("removed_cart_item");
    private By title = By.className("title");

    public BinTestPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return this;
    }

    public BinTestPage removeItem() {
        driver.findElement(removeButton).click();
        return this;
    }

    public BinTestPage verifyDelete() {
        Assert.assertTrue(driver.findElement(removedItem).isEnabled());
        return this;

    }

    private BinTestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());
    }
}













