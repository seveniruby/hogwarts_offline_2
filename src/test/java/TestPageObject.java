import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class TestPageObject {
    static AndroidDriver<AndroidElement> driver;
    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        //System.out.println(System.getenv("deviceName"));
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("", "");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "xx");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("automationName", "appium");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Category(冒烟测试.class)
    @Test
    public void testPageObject() throws InterruptedException {
        Page首页 首页=new Page首页(driver);
        Page自选 自选=首页.enter自选();
        List<String> name=自选.全部股票();
        System.out.println(name);
        Page股票详情页 detail=自选.enter股票详情页(name.get(2));
        assertThat(detail.getCurrentPrice(), greaterThan(200.0) );

        //todo: 定位需要自己定制，而不能照搬原有的注解，不然动态加载就会引发不稳定
    }
}


