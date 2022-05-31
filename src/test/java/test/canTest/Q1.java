package test.canTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q1 extends TestBase {
    @Test
    public void test(){
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//*[@data-test='username']")).sendKeys("standard_user");
        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@data-test='login-button']")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("//*[@alt='Sauce Labs Backpack']")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_container']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-test='remove-sauce-labs-backpack']")).isDisplayed());
        //9. Sayfayi kapatin
        driver.close();

    }

}
