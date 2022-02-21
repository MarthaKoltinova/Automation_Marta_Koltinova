package PageObject.saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CatalogTestPage extends BasePage {
    private By addToCard = By.name("add-to-cart-sauce-labs-backpack");
    private By shoppingCard = By.className("shopping_cart_link");
    private By count = By.className("shopping_cart_badge");
    private By title = By.className("title");


    public CatalogTestPage addItem() {
        driver.findElement(addToCard).click();
        return this;

    }
    public CatalogTestPage goToShoppingCard() {
        driver.findElement(shoppingCard).click();
        return this;
    }

    public CatalogTestPage countOfItems() {
        Assert.assertTrue((driver.findElement(count).isDisplayed()));
        return this;
    }

    private CatalogTestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());
    }
}
