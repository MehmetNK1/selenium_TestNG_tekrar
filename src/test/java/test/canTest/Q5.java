package test.canTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DemoIndexPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Q5 {
    @Test
    public void test(){
        DemoIndexPage demo = new DemoIndexPage();
        //    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        //~ http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
        Driver.getDriver().get("http://tutorialsninja.com/demo/index.php?route=common/home");
        //    ~ click on Phones & PDAs
        //     ~ Telefonlar ve PDA'lara tıklayın
        demo.phonesPdas.click();

        //    ~ get the brandName of phones
        //     ~ telefonların marka adını alın
        for (WebElement each:demo.phoneList) {
            System.out.println(each.getText());
        }
        //    ~ click on add to button for all elements
        //     ~ tüm öğeler için ekle düğmesine tıklayın
        for (WebElement each:demo.addCart) {
            each.click();
        }
        //    ~ click on black total added cart button
        //     ~ siyah toplam eklenen sepet düğmesine tıklayın
        demo.blackButton.click();

        //    ~ get the names of list from the cart
        //     ~ listenin isimlerini sepetten alın
        for (WebElement each:demo.nameOfList) {
            System.out.println(each.getText());
        }
        //    ~ compare the names from displaying list and cart list
        //     ~ listeden ve sepet listesinden isimleri karşılaştırın
        List<String> phoneListName = new ArrayList<>();
        for (WebElement each: demo.phoneList){
            phoneListName.add(each.getText());
        }
        List<String> nameOfListName = new ArrayList<>();
        for (WebElement each: demo.nameOfList){
            nameOfListName.add(each.getText());
        }
        Assert.assertTrue(phoneListName.containsAll(nameOfListName));
        Driver.closeDriver();
    }
}
