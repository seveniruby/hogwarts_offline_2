package pages.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PageBase {
    protected RemoteWebDriver driver;
    public PageBase(AppiumDriver driver){
        this.driver=driver;
    }
}
