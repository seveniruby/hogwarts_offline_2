package xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.utils.AppDriver;

public class Page登录 {
    By login_by_phone_or_others=By.id("tv_login_by_phone_or_others");
    By login_with_account=By.id("tv_login_with_account");
    By login_account=By.id("login_account");
    By login_password=By.id("login_password");
    By login=By.id("button_next");
    public Page雪球 login(String phone, String password){
        AppDriver.driver.findElement(login_by_phone_or_others).click();
        AppDriver.driver.findElement(login_with_account).click();
        AppDriver.driver.findElement(login_account).sendKeys(phone);
        AppDriver.driver.findElement(login_password).sendKeys(password);
        AppDriver.driver.findElement(login).click();
        return new Page雪球();
    }

}
