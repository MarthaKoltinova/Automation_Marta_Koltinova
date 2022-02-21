package Lesson9;
import BaseObjects.BaseTest;
import PageObject.saucedemo.*;
import org.testng.annotations.Test;
import static javax.swing.UIManager.get;

public class Lesson9 extends BaseTest{

    @Test(priority = 1)
    public void addItem() {
        get(CatalogTestPage.class).addItem().goToShoppingCard().countOfItems();
        get(BinTestPage.class).verifyPage();
    }

    @Test(priority = 2)
    public void removeItem() {
        get(BinTestPage.class).removeItem().verifyDelete().clickCheckout();
        get(CheckoutPage.class).verifyPage();
    }

    @Test(priority = 3)
    public void checkOutOrder() {
        get(CheckoutPage.class).sendInformation("Marta", "koltinova", "1111");
        get(Overview.class).verifyPage();
    }

    @Test(priority = 4)
    public void overview() {
        get(Overview.class).clickFinishButton();

    }

    @Test(priority = 5)
    public void completeInformation() {
        get(CompletePage.class).verifyPage();
    }
}
