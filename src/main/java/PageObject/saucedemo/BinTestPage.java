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
    private By backToShopping = By.id("continue-shopping");

    private By removeButton(int number) {
        return By.xpath("(//*[@class='item_pricebar']/button)[" + number + "]");
    }

    public BinTestPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return this;
    }
    public BinTestPage removeItem(int number) {
        driver.findElement(removeButton(number)).click();
        return this;
    }
    public BinTestPage clickOnContinueShopping() {
        driver.findElement(backToShopping).click();
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


























