package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;

public class Q3_softAssert extends TestBase {
    @Test
    public void test(){
        //Yeni bir Class Olusturun : C03_SoftAssert
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[@href='#ui-tabs-3']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select =  new Select(driver.findElement(By.xpath("//*[@id='pc_currency']")));
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String expectedOption = "Eurozone (Euro)";
        String actualOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualOption,expectedOption," secilmedi ");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        /*
        "Select One","Australia (dollar)","Canada (dollar)","Switzerland (franc)",
        "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
         */
        List<WebElement> optionList = select.getOptions();
        List<String> strOptionList = new ArrayList<String>();
        for (WebElement each : optionList) {
            strOptionList.add(each.getText());
        }
        List<String>actualOptionList = new ArrayList<String>(Arrays.asList("Select One","Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)",
                "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)" ));
        sort(strOptionList);
        sort(actualOptionList);
        softAssert.assertEquals(actualOptionList,strOptionList,"mevcur degil");
        softAssert.assertAll();

    }

}
