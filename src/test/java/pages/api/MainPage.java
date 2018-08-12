package pages.api;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    RemoteWebDriver driver;
    @AndroidFindBy(accessibility = "Views")
    RemoteWebElement views;
    public MainPage(RemoteWebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ViewsPage gotoViews(){
        views.click();
        return new ViewsPage(this.driver);
    }
}
