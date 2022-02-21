package BaseObjects;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;
public class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        this.driver = getDriver(browserName == null ? "chrome" : browserName);
    }

    @AfterTest
    public void postcondition() {
        closeDriver(browserName == null ? "chrome" : browserName);
    }
}
