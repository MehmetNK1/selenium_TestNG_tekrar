package test.day16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q1_assertionsPriority extends TestBase {
    @Test
    public void test(){
        //1)Bir class oluşturun: Youtube Assertions
        //2)https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@name='passive_signin']")));
        driver.findElement(By.xpath("//'*[@class='style-scope ytd-consent-bump-v2-lightbox style-primary size-default']")).click();
        driver.switchTo().defaultContent();

        //3)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin4
    }
    @Test (dependsOnMethods = "test")
    public void titleTest(){
        //○ titleTest => Sayfa başlığının YouTube ” oldugunu test edin

        Assert.assertTrue(driver.getTitle().contains("YouTube"));
    }
    @Test (dependsOnMethods = "titleTest")
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        System.out.println(driver.findElement(By.xpath("(//*[@class='style-scope ytd-topbar-logo-renderer'])[1]"))
                .isDisplayed() ? "3- image-passed" : "3- image-failled");

        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        System.out.println(driver.findElement(By.xpath("//*[@id='search-input']"))
                .isEnabled() ? "3- search-passed" : "3- search-failled");
    }
    @Test (dependsOnMethods = "imageTest")
    public void wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().contains("youtube"));
    }

}
