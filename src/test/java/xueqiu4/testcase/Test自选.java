package xueqiu4.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import xueqiu4.page.Page首页;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.OrderingComparison.*;

public class Test自选 {
    public static AppiumDriver driver;
    @BeforeClass
    public static void beforeClass() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/2.20");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void test沪深股票() throws InterruptedException {
        Page首页 page首页=new Page首页(driver);
        List<String> stocks=page首页.进入自选().get沪深股票();
        assertThat(stocks.size(), greaterThan(5));

    }
}
