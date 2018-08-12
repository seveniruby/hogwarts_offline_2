package xueqiu5.page;

import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class Page搜索 extends PageBase{

    By 搜索=By.id("search_input_text");
    By stockName=By.id("stockName");

    public Page搜索 search(String keys){
        driver.findElement(搜索).sendKeys(keys);
        return this;
    }

    public List<String> getStockList(){
        return driver.findElements(stockName).stream().map(e->e.getText()).collect(Collectors.toList());
    }
}
