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

    @Test(priority = 1)
    public void negative1LoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("standard_user", "password");
        get(CatalogTestPage.class).verifyPage();
    }

    @Test(priority = 2)
    public void negative2LoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("locked_out_user", "password");
        get(CatalogTestPage.class).verifyPage();
    }

    @Test(priority = 3)
    public void negative3LoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("username", "secret_sauced");
        get(CatalogTestPage.class).verifyPage();
    }

    @Test(priority = 4)
    public void positiveLoginTest() {
        get(HomePage.class).verifyPage();
        get(HomePage.class).logIn("standard_user", "secret_sauce");
        get(CatalogTestPage.class).verifyPage();
    }

}
