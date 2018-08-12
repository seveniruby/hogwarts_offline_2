package xueqiu5.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static AppiumDriver driver;
    public static void relaunch() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "iPhone 6");
            capabilities.setCapability("appPackage", "com.xueqiu.android");
            capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
            capabilities.setCapability("automationName", "uiautomator2");
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/2.20");
            capabilities.setCapability("avd", "Three");

            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
    public static void launch() throws MalformedURLException {
        if(driver==null) {
            relaunch();
        }
    }
}
