package xueqiu3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Page自选 {
    RemoteWebDriver driver;
    By 股票=By.xpath( "//*[@text='股票']");
    By 沪深=By.xpath("//*[@text='沪深']");
    By stocks=By.id("portfolio_stockName");

    public Page自选(RemoteWebDriver driver){
        this.driver=driver;
    }
    public void get沪深股票(){
        driver.findElement(股票).click();
        driver.findElement(沪深).click();
        driver.findElements(stocks).forEach(e-> System.out.println(e.getText()));
    }

    public Page股票 select股票(String name){
        for(WebElement element : driver.findElements(stocks)){
            if(element.getText().equals(name)){
                element.click();
                break;
            }
        }
        return new Page股票(driver);

    }


}
