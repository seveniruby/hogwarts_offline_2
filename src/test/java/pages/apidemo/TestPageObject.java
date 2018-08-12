package pages.apidemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class TestPageObject {
    private static AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", ".ApiDemos");
        capabilities.setCapability("automationName", "uiautomator2");
        //capabilities.setCapability("recreateChromeDriverSessions", "true");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("showChromedriverLog", true);
        capabilities.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/2.20");

        //capabilities.setCapability("dontStopAppOnReset", true);
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testPageObject(){
        MainPage main=new MainPage();
        PageFactory.initElements(new AppiumFieldDecorator(driver), main);
        ViewsPage viewsPage=main.gotoViews();
        PageFactory.initElements(new AppiumFieldDecorator(driver), viewsPage);
        PopupPage popupPage=viewsPage.gotoPopup();
        PageFactory.initElements(new AppiumFieldDecorator(driver), popupPage);
        popupPage.makePopupAdd();
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
