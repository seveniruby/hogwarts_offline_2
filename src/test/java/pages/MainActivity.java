package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainActivity {
    @FindBy(xpath = "//*[@text='蛋卷基金']")
    public WebElement 蛋卷基金;

    @FindBy(xpath = "//*[@text='首页']")
    public WebElement 首页;
    @FindBy(xpath = "//*[@text='自选']")
    public WebElement 自选;

    @FindBy(xpath = "//*[@text='动态']")
    WebElement 动态;

    public void enter自选() throws InterruptedException {
        //Thread.sleep(2000);
        自选.click();
    }
}
