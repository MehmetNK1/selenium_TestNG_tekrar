package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelmycampPage {
    public HotelmycampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//*[@href='/Account/Logon']")
    public WebElement Login;

    @FindBy (xpath = "//*[@class='form-control required']")
    public WebElement username;

    @FindBy (xpath = "//*[@class='form-control required password']")
    public WebElement password;

    @FindBy (id = "btnSubmit" )
    public WebElement loginGiris;
}
