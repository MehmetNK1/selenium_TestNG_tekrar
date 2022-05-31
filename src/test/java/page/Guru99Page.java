package page;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99Page {

    public Guru99Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
