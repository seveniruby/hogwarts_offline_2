import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestHub {
    @Test
    public void testRemoteHub() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("version", "6.0");
        capabilities.setCapability("deviceName", "demo");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");

        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.31.99:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(5000);
        driver.findElementById("cancel").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='交易']").click();

        driver.quit();
    }
}
