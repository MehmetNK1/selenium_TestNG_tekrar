package test.autoMationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AutoMationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase_01 {
    @Test
    public void test(){
        AutoMationExercisePage obj= new AutoMationExercisePage();

        //Test Durumu 1: Kullanıcıyı Kaydet
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationUrl"));
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(obj.anaSayfa.isDisplayed());
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        obj.singupLogin.click();
        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(obj.yenikulYazisi.isDisplayed());
        //6. Adı ve e-posta adresini girin
        obj.usernamekutusu.sendKeys("manager");
        obj.emailkutusu.sendKeys(ConfigReader.getProperty("autoEmail"));
        //7. 'Kaydol' düğmesini tıklayın
        obj.kaydol.click();
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());
        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        WebElement unvan = Driver.getDriver().findElement(By.xpath("(//*[@type='radio'])[1]"));

        Actions actions = new Actions(Driver.getDriver());
        actions.click(unvan)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("Manager1@").sendKeys(Keys.TAB)
                .sendKeys("1").sendKeys(Keys.TAB)
                .sendKeys("January").sendKeys(Keys.TAB)
                .sendKeys("2000").sendKeys(Keys.TAB)
                //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
                .click(Driver.getDriver().findElement(By.xpath("//*[@name='newsletter']")))
                //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
                .click(Driver.getDriver().findElement(By.xpath("//*[@name='optin']"))).click().sendKeys(Keys.TAB)
                //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
                .sendKeys("mana").sendKeys(Keys.TAB)
                .sendKeys("ger").sendKeys(Keys.TAB)
                .sendKeys("meftune").sendKeys(Keys.TAB)
                .sendKeys("leipziger").sendKeys(Keys.TAB)
                .sendKeys("leipziger").sendKeys(Keys.TAB)
                .sendKeys("Canada").sendKeys(Keys.TAB)
                .sendKeys("sachen").sendKeys(Keys.TAB)
                .sendKeys("Zwickau").sendKeys(Keys.TAB)
                .sendKeys("08080").sendKeys(Keys.TAB)
                .sendKeys("49123456789").sendKeys(Keys.TAB)
                .perform();
        //13. 'Hesap Oluştur düğmesini' tıklayın

        //14. 'HESAP OLUŞTURULDU!' görünür
        //15. 'Devam' düğmesini tıklayın
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        //17. 'Hesabı Sil' düğmesini tıklayın
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın

    }
    //Test Case 1: Register User
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
}
