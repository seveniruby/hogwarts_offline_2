package pages.api;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupPage {
    RemoteWebDriver driver;

    @AndroidFindBy(accessibility = "Make a Popup!")
    WebElement makePopup;

    @FindBy(xpath = "//android.widget.TextView[@text='Add']")
    WebElement add;

    public PopupPage(RemoteWebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void makePopup(){
        makePopup.click();
        add.click();
    }


}
