package ios;

import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestIOS {
    @Test
    public void UICatalogTest() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "11.4");
        caps.setCapability("deviceName", "iPhone 8");
        caps.setCapability("app",
                "/Users/seveniruby/Library/Developer/Xcode/DerivedData/UICatalog-ftyzdbgapjmxxobezrnrxsshpdqh/Build/Products/Debug-iphonesimulator/UICatalog.app");

        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        System.out.println(driver.getPageSource());
        for(WebElement e: driver.findElementsByXPath("//*[@name!='']")){
            System.out.println(e.getText());
            System.out.println(e.getTagName());
        }

    }

    @Test
    public void UICatalogTestClick() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "11.2");
        caps.setCapability("deviceName", "iPhone X");
        caps.setCapability("app",
                "/Users/seveniruby/Library/Developer/Xcode/DerivedData/UICatalog-ftyzdbgapjmxxobezrnrxsshpdqh/Build" +
                        "/Products/Debug-iphonesimulator/UICatalog.app");

        AppiumDriver driver=new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getPageSource());
        driver.findElementByAccessibilityId("Buttons").click();
        System.out.println(driver.findElementsByXPath("//*[contains(@type, 'Button')]"));
    }

    @Test
    public void testGrid() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("deviceName", "dd");
        caps.setCapability("appPackage", "com.xueqiu.android");
        caps.setCapability("appActivity", "view.WelcomeActivityAlias");

        AppiumDriver driver=new AppiumDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getPageSource());
    }

}
