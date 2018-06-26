package pages.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainActivity {
    private AppiumDriver driver;
    @FindBy(xpath = "//*[@text='蛋卷基金']")
    public WebElement 蛋卷基金;
    @FindBy(xpath = "//*[@text='首页']")
    public WebElement 首页;
    @FindBy(xpath = "//*[@text='自选']")
    public WebElement 自选;
    @FindBy(xpath = "//*[@text='动态']")
    WebElement 动态;

    public MainActivity(AppiumDriver driver){
        PageFactory.initElements(driver, this);
    }
}
