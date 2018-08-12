package pages.xueqiudemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//*[@text='自选']")
    WebElement 自选;
    @FindBy(xpath = "//*[@text='行情']")
    WebElement 行情;

    @FindBy(id = "cancel")
    WebElement cancel;

    public Page自选 goto自选(){
        cancel.click();
        自选.click();
        return new Page自选();
    }



}
