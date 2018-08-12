package xueqiu3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import java.rmi.Remote;

public class Page股票 {
    RemoteWebDriver driver;
    By name=By.id("action_bar_stock_name");
    By price=By.id("stock_current_price");

    public Page股票(RemoteWebDriver driver){
        this.driver=driver;
    }
    public Double getPrice(){
        return Double.valueOf(driver.findElement(price).getText());
    }
    public String getName(){
        return driver.findElement(name).getText();
    }
}
