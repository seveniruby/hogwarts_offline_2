package xueqiu4.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Page首页 {
    private AppiumDriver<WebElement> driver;
    By 自选=By.xpath("//*[@text='自选']");
    By 问答广场 =By.xpath("//*[@text='问答广场']");
    By 跳过=By.xpath("//*[@text='跳过']");
    By 取消=By.id("cancel");
    public Page自选 进入自选() throws InterruptedException {
        Thread.sleep(5000);
        if(driver.findElements(跳过).size()>0) {
            driver.findElement(跳过).click();
        }
        if(driver.findElements(取消).size()>0) {
            driver.findElement(取消).click();
        }
        Thread.sleep(2000);
        driver.findElement(自选).click();
        return new Page自选(driver);
    }
    public Page首页(AppiumDriver driver){
        this.driver=driver;
    }

}
