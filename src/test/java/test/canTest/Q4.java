package test.canTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q4 extends TestBase {

    @Test
    public void test(){
        //    http://demo.guru99.com/test/drag_drop.html url e git
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.findElement(By.xpath("(//*[@class='fc-button-label'])[1]")).click();
        //    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        Actions actions =new Actions(driver);
        WebElement tasinacak1= driver.findElement(By.xpath("(//*[@class='button button-orange'])[5]"));
        WebElement hedef1= driver.findElement(By.xpath("(//*[@class='placeholder'])[1]"));
        actions.dragAndDrop(tasinacak1,hedef1).perform();
        //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        WebElement tasinacak2 = driver.findElement(By.xpath("(//*[@class='button button-orange'])[6]"));
        WebElement hedef2 = driver.findElement(By.xpath("(//*[@class='placeholder'])[2]"));
        actions.dragAndDrop(tasinacak2,hedef2).perform();
        //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        WebElement tasinacak3 = driver.findElement(By.xpath("(//*[@class='button button-orange'])[2]"));
        WebElement hedef3 = driver.findElement(By.xpath("(//*[@class='placeholder'])[1]"));
        actions.dragAndDrop(tasinacak3,hedef3).perform();
        //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        WebElement tasinacak4 = driver.findElement(By.xpath("(//*[@class='button button-orange'])[4]"));
        WebElement hedef4 =driver.findElement(By.xpath("//*[@class='placeholder']"));
        actions.dragAndDrop(tasinacak4,hedef4).perform();
        //    Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='button button-green']")).isDisplayed());

    }
}
