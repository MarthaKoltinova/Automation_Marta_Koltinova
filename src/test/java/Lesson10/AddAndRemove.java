package Lesson10;

import BaseObjects.BaseTest;
import PageObject.saucedemo.BinTestPage;
import PageObject.saucedemo.CatalogTestPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddAndRemove extends BaseTest {
    int i = 0;

    @Test(priority = 1, invocationCount = 3)
    public void addElements() {
        get(CatalogTestPage.class)
                .addItem(i)
                .countOfItems();
        i++;
    }

    @Test(priority = 2, invocationCount = 2)
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
    public void addItems(int number) {
        get(CatalogTestPage.class)
                .addItem(number)
                .countOfItems();
    }

    @Test(priority = 3, dataProvider = "removeItems")
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