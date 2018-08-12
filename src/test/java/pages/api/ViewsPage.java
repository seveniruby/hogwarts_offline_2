package pages.api;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ViewsPage {
    RemoteWebDriver driver;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView("
            + "new UiSelector().text(\"Popup Menu\"));")
    RemoteWebElement popupView;
    List<String> menus=new ArrayList<String>();
    public ViewsPage(RemoteWebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public PopupPage gotoPopup(){
        popupView.click();
        PopupPage popupPage=new PopupPage(driver);
        return new PopupPage(this.driver);
    }
}
