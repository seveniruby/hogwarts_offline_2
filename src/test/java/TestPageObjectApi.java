import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.api.MainPage;
import pages.xueqiu.Page股票详情页;
import pages.xueqiu.Page自选;
import pages.xueqiu.Page首页;
import tags.冒烟测试;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class TestPageObjectApi {
    static AndroidDriver<AndroidElement> driver;
    @BeforeClass
    public static void beforeClass() throws MalformedURLException {

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
    @Category(冒烟测试.class)
    @Test
    public void testPageObjectApi() throws InterruptedException {
        MainPage main=new MainPage(driver);
        main.gotoViews().gotoPopup().makePopup();

        //todo: 定位需要自己定制，而不能照搬原有的注解，不然动态加载就会引发不稳定
    }
}


