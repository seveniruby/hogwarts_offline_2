package xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.utils.AppDriver;

public class Page雪球 {

    private By cancel=By.id("cancel");
    private By search=By.id("tv_search");
    By profile= By.id("user_profile_icon");

    public Page雪球(){
        if(AppDriver.driver.findElements(cancel).size()>0) {
            AppDriver.driver.findElement(cancel).click();
        }
    }
    public Page搜索 enterSearch(){
        AppDriver.driver.findElement(search).click();
        return new Page搜索();
    }
    public Page个人页 enterLogin(){
        AppDriver.driver.findElement(profile).click();
        return new Page个人页();
    }

}
