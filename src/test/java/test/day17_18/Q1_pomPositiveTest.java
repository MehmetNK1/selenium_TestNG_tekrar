package test.day17_18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelmycampPage;

import utilities.Driver;

public class Q1_pomPositiveTest {

    @Test
            public void test01(){
        HotelmycampPage hotelmycampPage =new HotelmycampPage();

        //1 ) Bir Class olustur: Posi tiveTest
        //2) Bir test method olustur positiveLoginTest()
        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        //login butonuna bas
        hotelmycampPage.Login.click();

        //test data username: manager
        hotelmycampPage.username.sendKeys("manager"+ Keys.ENTER);

        //test data password : Manager1!
        hotelmycampPage.password.sendKeys("Manager1!");

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelmycampPage.loginButonGiris.click();
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(hotelmycampPage.girislogin).perform();
        Assert.assertTrue(hotelmycampPage.logout.isDisplayed());


    }



}
