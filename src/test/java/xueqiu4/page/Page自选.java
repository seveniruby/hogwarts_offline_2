package xueqiu4.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Page自选 {
    private AppiumDriver<WebElement> driver;
    By 股票=By.xpath("//*[@text='股票']");
    By 沪深=By.xpath("//*[@text='沪深']");
    By stockName=By.id("stockName");
    List<String> stocks=new ArrayList<>();

    public List<String> get沪深股票(){
        driver.findElement(股票).click();
        driver.findElement(沪深).click();
        for(WebElement element: driver.findElements(stockName)){
            stocks.add(element.getText());
        };
        return stocks;
    }
    public Page自选(AppiumDriver driver){
        this.driver=driver;
    }
}
