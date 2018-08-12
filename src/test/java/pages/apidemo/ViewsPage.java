package pages.apidemo;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ViewsPage {
    WebElement webview;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView("
            + "new UiSelector().text(\"Popup Menu\"));")
    WebElement popup;

    public PopupPage gotoPopup(){
        popup.click();
        return new PopupPage();
    }

}
