package pages.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.xueqiu.Page自选;

public class Page首页 {
    private AppiumDriver driver;

    By button蛋卷基金=By.xpath("//*[@text='蛋卷基金']");
    By button首页=By.xpath("//*[@text='首页']");
    By button自选=By.xpath("//*[@text='自选']");
    By button动态=By.xpath("//*[@text='自选']");
    By buttonCancel=By.id("cancel");

    public Page自选 enter自选() throws InterruptedException {
        if(driver.findElements(buttonCancel).size()>0){
            driver.findElement(buttonCancel).click();
        }
        Thread.sleep(2000);
        driver.findElement(button自选).click();
        return new Page自选(driver);
    }

    public Page首页(AppiumDriver driver){
        this.driver=driver;
    }
}
