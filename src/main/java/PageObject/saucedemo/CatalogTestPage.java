package PageObject.saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CatalogTestPage extends BasePage {
    By addToCard = By.xpath("//*[@class='pricebar']//button");
    List<WebElement> list = driver.findElements(addToCard);

    private By shoppingCard = By.className("shopping_cart_link");
    private By count = By.className("shopping_cart_badge");
    private By title = By.className("title");


    public CatalogTestPage addItem(int a) {
        list.get(a).click();
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

    public CatalogTestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());
    }
}

