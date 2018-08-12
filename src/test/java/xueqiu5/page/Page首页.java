package xueqiu5.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xueqiu4.page.Page自选;

public class Page首页 extends PageBase {
    By 自选=By.xpath("//*[@text='自选']");
    By 问答广场 =By.xpath("//*[@text='问答广场']");
    By 跳过=By.xpath("//*[@text='跳过']");
    By 搜索=By.id("home_search");
    By 取消=By.id("cancel");

    public Page首页() throws InterruptedException {
        super();
        Thread.sleep(5000);
        if(driver.findElements(跳过).size()>0) {
            driver.findElement(跳过).click();
        }
        if(driver.findElements(取消).size()>0) {
            driver.findElement(取消).click();
        }
    }
    public Page自选 进入自选() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(跳过).click();
        Thread.sleep(2000);
        driver.findElement(自选).click();
        return new Page自选(driver);
    }

    public Page搜索 进入搜索(){
        driver.findElement(搜索).click();
        return new Page搜索();
    }

}
