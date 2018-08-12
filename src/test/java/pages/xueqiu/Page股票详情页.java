package pages.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Page股票详情页 extends PageBase {
    By currentPrice=By.id("stock_current_price");
    public Page股票详情页(AppiumDriver driver){
        super(driver);
    }
    public Double getCurrentPrice() throws InterruptedException {
        Thread.sleep(1000);
        return Double.valueOf(driver.findElement(currentPrice).getText());
    }
}
