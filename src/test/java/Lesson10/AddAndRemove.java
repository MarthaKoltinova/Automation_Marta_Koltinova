package Lesson10;

import BaseObjects.BaseTest;
import PageObject.saucedemo.BinTestPage;
import PageObject.saucedemo.CatalogTestPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddAndRemove extends BaseTest {
    int i = 0;

    @Test(priority = 1, invocationCount = 3)
    @Description("Add elements")
    @Step("Add elements 3 times")
    @Link("https://instagram.com/")
    public void addElements() {
        get(CatalogTestPage.class)
                .addItem(i)
                .countOfItems();
        i++;
    }

    @Test(priority = 2, invocationCount = 2)
    @Description("Remove elements")
    @Step("Remove elements 2 times")
    @Link("https://instagram.com/")
    public void removeElements() {
        get(CatalogTestPage.class)
                .goToShoppingCard();
        get(BinTestPage.class)
                .verifyPage();
        get(BinTestPage.class)
                .removeItem(1)
                .verifyDelete();
    }

    @Test(priority = 3, dataProvider = "addItems")
    @Description("Add elements with DataProvider")
    @Step("Add elements with DataProvider to BinPage")
    @Link("https://instagram.com/")
    public void addItems(int number) {
        get(CatalogTestPage.class)
                .addItem(number)
                .countOfItems();
    }

    @Test(priority = 3, dataProvider = "removeItems")
    @Description("Remove elements with DataProvider")
    @Step("Remove elements")
    @Link("https://instagram.com/")
    public void removeItems(int number) {
        get(CatalogTestPage.class)
                .goToShoppingCard();
        get(BinTestPage.class)
                .verifyPage();
        get(BinTestPage.class)
                .removeItem(number)
                .verifyDelete();
    }


    @DataProvider(name = "addItems")
    private Object[][] objects() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4}
        };
    }

    @DataProvider(name = "removeItems")
    private Object[][] remove() {
        return new Object[][]{
                {1},
                {2},


        };
    }
}
