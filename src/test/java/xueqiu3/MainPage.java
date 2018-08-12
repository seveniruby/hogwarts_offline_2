package xueqiu3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    RemoteWebDriver driver;
    By 自选=By.xpath("//*[@text='自选']");
    By 行情=By.xpath("//*[@text='行情']");
    By cancel=By.id("cancel");
;
    public MainPage(RemoteWebDriver driver){
        this.driver=driver;
    }
    public Page自选 goto自选(){
        driver.findElement(cancel).click();
        driver.findElement(自选).click();
        return new Page自选(driver);
    }



}
