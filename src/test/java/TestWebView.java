import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestWebView {
    @Test
    public void testChromeDriverAppum() throws MalformedURLException {

        //8.0有个bug， 需要自己手动forward端口
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("androidPackage", "io.appium.android.apis");
        options.setExperimentalOption("androidUseRunningApp", true);
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName", "android");
        cap.setCapability("chromeOptions", options);
        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:8000/wd/hub"), cap);
        driver.get("http://www.baidu.com");

    }

    @Test
    public void testWebView2() throws InterruptedException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "demo");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", ".ApiDemos");
        //capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("showChromedriverLog", true);
        //capabilities.setCapability("dontStopAppOnReset", true);


        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.findElementByAccessibilityId("Views").click();
        MobileElement webview = driver.findElement(By.id("android:id/list"))
                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"WebView\"));"));
        webview.click();
        System.out.println(driver.getContextHandles());

        for(AndroidElement e : driver.findElementsByXPath("//*")){
            System.out.println(e.getTagName());
            System.out.println(e.getText());
        }

        driver.context(driver.getContextHandles().toArray()[1].toString());


        for(AndroidElement e : driver.findElementsByXPath("//*")){
            System.out.println(e.getTagName());
            System.out.println(e.getText());
        }

        Thread.sleep(10000);




    }


}
