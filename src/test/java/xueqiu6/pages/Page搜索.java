package xueqiu6.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xueqiu6.utils.AppDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Page搜索 {
    By search=By.id("search_input_text");
    By stockName=By.id("stockName");
    By userName=By.id("user_name");
    By cancel=By.id("action_close");

    public Page搜索 search(String keyword){
        AppDriver.driver.findElement(search).sendKeys(keyword);
        return this;
    }
    public List<String> getStockNames(){
        return AppDriver.driver.findElements(stockName).stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public List<String> getUserNames(){
        return AppDriver.driver.findElements(userName).stream().map(e->e.getText()).collect(Collectors.toList());
    }
    public Page雪球 enterXueqiu(){
        AppDriver.driver.findElement(cancel).click();
        return new Page雪球();
    }


}
