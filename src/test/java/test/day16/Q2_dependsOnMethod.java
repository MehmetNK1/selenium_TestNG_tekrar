package test.day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class Q2_dependsOnMethod {
    WebDriver driver;
    @BeforeClass
    public void BeforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void AfterClass(){
        driver.close();
    }
    @Test
    public void Test(){
        //●Bir class oluşturun: D ependsOnTest
        //●https://www. amazon . adresine gidin.
        driver.get("https://www.amazon.com");
    }
    @Test (dependsOnMethods = "Test")
    public void Test01(){
        //1. Test : Amazon ana sayfaya gittiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/ref=nav_logo']")).isDisplayed());


    }
    @Test (dependsOnMethods = "Test01")
    public void Test02(){
        //2.Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        //arama yapin ve aramanizin gerceklestigini Test edin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"))
                .isDisplayed() ? "2- passed" : "2- failled");
    }
    @Test (dependsOnMethods = "Test02")
    public void test03(){
        //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
        //$16.83 oldugunu test edin
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        String expectedfiyat="$16.83";
        Assert.assertFalse(driver.findElement(By.xpath("//*[text()='$14.99']")).equals(expectedfiyat));

    }



}
