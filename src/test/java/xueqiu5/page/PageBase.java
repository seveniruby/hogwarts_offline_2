package xueqiu5.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import xueqiu5.util.Driver;

public class PageBase {
    protected AppiumDriver<WebElement> driver;

    public PageBase(AppiumDriver driver){
        this.driver=driver;
    }
    public PageBase(){
        this.driver= Driver.driver;
    }
}
