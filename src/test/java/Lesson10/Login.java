package Lesson10;

import BaseObjects.BaseTest;
import PageObject.saucedemo.CatalogTestPage;
import PageObject.saucedemo.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BaseTest {
    @BeforeMethod
    public void preconditions() {
        driver.get(context.getSuite().getParameter("url"));
    }

    @Test(description = "First negative test",priority = 1)
    @Description("Entering wrong login")
    @Step("1. Login is wrong")
    @Link("https://instagram.com/")
    public void negative1LoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("standard_user", "password");
        get(CatalogTestPage.class).verifyPage();
    }

    @Test(description = "Second negative test",priority = 2)
    @Description("Entering wrong login")
    @Step("2. Login is wrong")
    @Link("https://instagram.com/")
    public void negative2LoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("locked_out_user", "password");
        get(CatalogTestPage.class).verifyPage();
    }

    @Test(description = "Third negative test",priority = 3)
    @Description("Entering wrong login")
    @Step("3. Login is wrong")
    @Link("https://instagram.com/")
    public void negative3LoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("username", "secret_sauced");
        get(CatalogTestPage.class).verifyPage();
    }

    @Test(description = "Positive test",priority = 4)
    @Description("Entering right login")
    @Step("4. Login is correct")
    @Link("https://instagram.com/")
    public void positiveLoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("standard_user", "secret_sauce");
        get(CatalogTestPage.class).verifyPage();
    }

}
