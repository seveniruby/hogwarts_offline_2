package xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.utils.AppDriver;

public class Page个人页 {
    By login=By.id("tv_login");
    public Page登录 enterLogin(){
        AppDriver.driver.findElement(login).click();
        return new Page登录();
    }

}
