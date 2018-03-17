package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome {
    @FindBy(xpath = "//*[@text='跳过']")
    WebElement 跳过;
    @FindBy(xpath = "//*[@text='下一步']")
    WebElement 下一步;
    public void click跳过(){
        跳过.click();
    }
}
