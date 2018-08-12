package pages.xueqiudemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.apidemo.PopupPage;
import pages.apidemo.ViewsPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

public class TestPageObject {

    private static AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("automationName", "uiautomator2");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    }

    @Test
    public void testPageObject(){
        MainPage mainPage=new MainPage();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), mainPage);
        Page自选 page自选=mainPage.goto自选();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), page自选);
        page自选.get沪深股票();
        Page股票 page股票=page自选.select股票("青岛海尔");
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), page股票);
        assertThat(page股票.getName(), equalTo("青岛海尔"));
        assertThat(page股票.getPrice(), greaterThan(30.15));
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
