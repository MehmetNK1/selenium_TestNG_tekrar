package test.day17_18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class Q2_pomNegativeTest extends TestBase {

    @Test
    public void test(){
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        //1 ) Bir Class olustur: NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp"));
        //login butonuna bas
        hotelmycampPage.Login.click();
        //test data username: manager1
        hotelmycampPage.username.sendKeys("manager1"+ Keys.ENTER);
        //test data password : manager 1
        hotelmycampPage.password.sendKeys("manager1"+ Keys.ENTER);
        //Degerleri girildiginde sayfaya girilemedigini test et
        hotelmycampPage.loginButonGiris.click();
        Assert.assertTrue(hotelmycampPage.girilemediYazisi.isDisplayed());
    }


}
