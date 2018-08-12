package pages.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.xueqiu.Page股票详情页;

import java.util.ArrayList;
import java.util.List;

public class Page自选 {
    private AppiumDriver<WebElement> driver;
    List<String> stocks=new ArrayList<String>();
    public List<String> 全部股票(){
        driver.findElementByXPath("//*[@text='股票']").click();
        driver.findElementByXPath("//*[@text='全部']").click();
        //todo: 用xpath获取所有的股票
        driver.findElement(By.id("listview")).findElements(By.id("portfolio_stockName")).forEach(e->{
            stocks.add(e.getText());
        });
        return stocks;
    }
    public Page股票详情页 enter股票详情页(String name){
        driver.findElement(By.id("listview"))
                .findElement(By.xpath("//*[@text='"+ name+ "']")).click();
         return new Page股票详情页(driver);
    }

    public Page自选(AppiumDriver driver){
        this.driver=driver;
    }
}
