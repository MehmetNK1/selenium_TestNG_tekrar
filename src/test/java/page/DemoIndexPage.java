package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoIndexPage {
    public DemoIndexPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[text()='Phones & PDAs']")
    public WebElement phonesPdas;
    @FindBy (xpath = "//div//h4")
    public List<WebElement> phoneList;
    @FindBy (xpath = "//*[text()='Add to Cart']")
    public List<WebElement> addCart;
    @FindBy (xpath = "(//button[@type='button'])[5]")
    public WebElement blackButton;
    @FindBy (xpath = "//*[@class='text-left']")
    public List<WebElement> nameOfList;

}
