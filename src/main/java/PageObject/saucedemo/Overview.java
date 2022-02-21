package PageObject.saucedemo;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Overview extends BasePage{
    private By finishButton = By.id("finish");
    private By title = By.className("title");

    protected Overview(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        Assert.assertTrue(driver.findElement(title).isDisplayed());
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
    }


