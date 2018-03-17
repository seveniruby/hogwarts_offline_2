import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.MainActivity;
import pages.Welcome;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestPageObject {
    static AndroidDriver<AndroidElement> driver;
    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("", "");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "ddd");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("automationName", "appium");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void testPageObject() throws InterruptedException {
        MainActivity main=new MainActivity();
        PageFactory.initElements(driver, main);
        Welcome welcome=new Welcome();
        PageFactory.initElements(driver, welcome);

        welcome.click跳过();
        Thread.sleep(2000);
        //todo: 定位需要自己定制，而不能照搬原有的注解，不然动态加载就会引发不稳定
        main.enter自选();
    }
}


