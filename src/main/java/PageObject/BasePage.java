package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public abstract class  BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
    abstract public void verifyPage();
}
