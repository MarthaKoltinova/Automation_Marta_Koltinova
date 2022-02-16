package Lesson8;

import BaseObjects.BaseTest;
import com.google.common.io.ByteSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Lesson8 extends BaseTest {
    @Test(priority = 1)
    public void checkFirstValueInList() {
       driver.get("C:\\Users\\marta\\IdeaProjects\\Automation_Marta_Koltinova\\src\\test\\java\\Lesson8\\index.html");
        //Создать коллекцию из значений в первой колонке
        List<String> brandsStringList = driver.findElements(By.cssSelector("//tr//td")).stream().map(el -> el.getText()).collect(Collectors.toList());
        Assert.assertEquals(brandsStringList.get(0), "Volkswagen");
    }

    @Test(priority = 1)
    public void createCollectionMap() {
        List<String> brandsList = driver.findElements(By.tagName("th")).stream().map(el -> el.getText()).collect(Collectors.toList());
        Map<String, List<String>> tableData = new HashMap<>();
        for (int i = 0; i < brandsList.size(); i++) {
            List<String> column = driver.findElements(By.xpath("//tr/td[" + (i + 1) + "]")).stream().map(el -> el.getText()).collect(Collectors.toList());
            tableData.put(brandsList.get(i),column);
        }
        System.out.println(tableData.get("Brand").get(0));
    }


    @Test(priority = 2)
    public void checkElementsOnPage() {
        driver.findElement(By.id("type")).sendKeys("Паркетник");
        driver.findElement(By.id("transmission")).sendKeys("Механика");
        driver.findElement(By.name("yes_answer")).click();
        driver.findElement(By.className("button")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Запись')]")).click();
        driver.findElement(By.tagName("a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.volkswagen.by.html");
    }
}
