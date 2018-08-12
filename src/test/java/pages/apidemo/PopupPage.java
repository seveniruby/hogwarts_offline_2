package pages.apidemo;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupPage {

    @AndroidFindBy(accessibility = "Make a Popup!")
    WebElement makePopup;

    @FindBy(xpath = "//android.widget.TextView[@text='Add']")
    WebElement add;

    public String makePopupAdd(){
        makePopup.click();
        add.click();
        return "";
    }


}
