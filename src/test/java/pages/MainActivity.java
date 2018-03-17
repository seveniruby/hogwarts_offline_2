package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainActivity {
    @FindBy(xpath = "//*[@text='首页']")
    WebElement 首页;
    @FindBy(xpath = "//*[@text='自选']")
    WebElement 自选;
    public void enter自选(){
        自选.click();
    }
}
