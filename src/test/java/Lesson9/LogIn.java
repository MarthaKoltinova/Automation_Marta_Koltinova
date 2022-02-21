package Lesson9;
import BaseObjects.BaseTest;
import PageObject.saucedemo.HomePage;
import PageObject.saucedemo.CatalogTestPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

public class LogIn extends BaseTest{
    String PASSWORD = "secret_sauce";
    @Test(dataProvider = "login")
    public void checkAuthorization(String username, String password) {
        driver.get(context.getSuite().getParameter("url"));
        get(HomePage.class).logIn(username, password);
    }


    List<String> userNames = new ArrayList() {{
        add("standard_user");
        add("problem_user");
        add("locked_out_user");
        add("performance_glitch_user");

    }};

    @DataProvider(name = "login")
    private Object[][] getData() {
        return new Object[][]{
                {userNames.get(1),PASSWORD },
                {userNames.get(2),PASSWORD},
                {userNames.get(3), PASSWORD}

        };
    }}
