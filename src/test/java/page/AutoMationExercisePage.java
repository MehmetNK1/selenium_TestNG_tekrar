package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutoMationExercisePage {
    public AutoMationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@href='/']")
    public WebElement anaSayfa;
    @FindBy (xpath = "//*[@href='/login']")
    public WebElement singupLogin;
    @FindBy (xpath = "//*[text()='New User Signup!']")
    public WebElement yenikulYazisi;
    @FindBy (xpath = "//*[@data-qa='signup-name']")
    public WebElement usernamekutusu;
    @FindBy (xpath = "//*[@data-qa='signup-email']")
    public WebElement emailkutusu;
    @FindBy (xpath = "//*[@data-qa='signup-button']")
    public WebElement kaydol;
    @FindBy (xpath = "(//*[@class='form-control'])[3]")
    public WebElement passkutusu;




}
