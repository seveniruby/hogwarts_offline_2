import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestWeiXin {


    @Test
    public void testBrowser() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "seveniruby");
        caps.setCapability("browserName", "chrome");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.get("https://sogou.com");
        System.out.println(driver.getPageSource());
        driver.findElementByName("phone").sendKeys("霍格沃兹测试学院");
        driver.findElementByXPath("//*[@id='searchform']//*[@type='submit']").click();

    }

    @Test
    public void testWebView() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.xueqiu.android");
        caps.setCapability("appActivity", ".view.WelcomeActivityAlias");
        caps.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/2.20");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

        if (driver.findElementsById("cancel").size() > 0) {
            driver.findElementById("cancel").click();
        }
        driver.findElementByXPath("//*[@text='交易']").click();

        System.out.println("等待webview上下文");
        for (int i = 0; i < 5; i++) {
            System.out.println(driver.getContextHandles());
            Thread.sleep(1000);
        }
        driver.getContextHandles().forEach(context -> {
            driver.context(context.toString());
            System.out.println("context=" + context);
            System.out.println(driver.getPageSource());
        });

    }


    @Test
    public void testDianPing() throws IOException, InterruptedException {

        String processName = "com.tencent.mm:appbrand0";
        String packageName = "com.tencent.mm";
        String activityName = ".ui.LauncherUI";
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "dd");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("appPackage", packageName);
        caps.setCapability("appActivity", activityName);
        //如果没有这个设置你的微信聊天记录就会被清空
        caps.setCapability("noReset", true);
        //caps.setCapability("dontStopAppOnReset", true);
        caps.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/2.29");
        caps.setCapability("showChromedriverLog", true);
        //低版本的chromedriver在高版本的android上有个兼容性的bug，需要自己定制解决方案
        //caps.setCapability("adbPort", 5038);

        //todo: appium java client 6.0.0 有多个bug，待修复
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setExperimentalOption("androidUseRunningApp", true);
        //chromeOptions.setExperimentalOption("androidPackage", packageName);
        //chromeOptions.setExperimentalOption("androidActivity", activityName);
        chromeOptions.setExperimentalOption("androidProcess", processName);
        //caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        caps.setCapability("chromeOptions", chromeOptions);
        //todo: 6.0.0独有的bug，会自动设置browserName
        caps.setCapability("browserName", "");
        System.out.println(caps.asMap());

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        //todo: 5.0.3不支持1.8.1的timeout接口
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElementByXPath("//*[@text='通讯录']");
        //滑动
        swipe(driver);

        System.out.println("点击小程序");
        driver.findElementByXPath("//*[contains(@text, '点评')]").click();

        System.out.println("打印上下文");
        for (int i = 0; i < 3; i++) {
            System.out.println(driver.getContextHandles());
            Thread.sleep(1000);
        }

        System.out.println("切换上下文到 " + "WEBVIEW_" + processName);
        driver.context("WEBVIEW_" + processName);
        System.out.println(driver.getContextHandles());
        System.out.println(driver.getContext());
        System.out.println(driver.getPageSource());

        System.out.println("打印上下文，寻找小程序界面");
        System.out.println(driver.getWindowHandles());
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            System.out.println("windows=" + window);
            String source = driver.getPageSource();
            if (source.contains("<wx-view")) {
                System.out.println(source);
                break;
            }
        }
        driver.findElementByXPath("//*[contains(text(), '外卖')]").click();
        //6.0 beta5 修复了timeout问题

    }

    @Test
    public void testDianPingByChromeDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setExperimentalOption("androidUseRunningApp", true);
        chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
        //chromeOptions.setExperimentalOption("androidActivity", ".plugin.appbrand.ui.AppBrandUI");
        //chromeOptions.setExperimentalOption("androidActivity", ".ui.LauncherUI");
        //chromeOptions.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand0");
        caps.setCapability("chromeOptions", chromeOptions);
        caps.setCapability("browserName", "");
        URL url = new URL("http://127.0.0.1:8000/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, caps);

        System.out.println(driver.getPageSource());
    }

/*
    public void swipe(AppiumDriver driver) {

        Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        new TouchAction(driver)
                .press(
                        (int) (size.getWidth() * 0.5),
                        (int) (size.getHeight() * 0.3)
                )
                .waitAction(Duration.ofSeconds(2))
                .moveTo(

                        (int) (size.getWidth() * 0.5),
                        (int) (size.getHeight() * 0.9)
                )
                .release()
                .perform();
    }*/





     public void swipe(AppiumDriver driver) {
     Dimension size = driver.manage().window().getSize();
     System.out.println(size);
     new TouchAction(driver)
     .press(
     PointOption.point(
     (int) (size.getWidth() * 0.5),
     (int) (size.getHeight() * 0.3)
     )
     )
     .waitAction(
     WaitOptions.waitOptions(
     Duration.ofSeconds(2)
     )
     )
     .moveTo(
     PointOption.point(
     (int) (size.getWidth() * 0.5),
     (int) (size.getHeight() * 0.9))
     )
     .release()
     .perform();
     }


}

