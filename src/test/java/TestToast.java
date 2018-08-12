import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestToast {

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
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:5723/wd/hub"), capabilities);
    }


    @Test
    public void testToast0() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(5000);
        driver.findElementByAccessibilityId("Views").click();
        //find locator action
        //findRich("Views")
        Thread.sleep(2000);
        //(new TouchAction(driver)).press(748, 2220).moveTo(748, 500).release().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Popup Menu']"))).click();
        //driver.findElementByAccessibilityId("Popup Menu").click();
        driver.findElementByAccessibilityId("Make a Popup!").click();
        //locate("//*[contains(@text, 'MAKE')]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[contains(@text,'Search')]").click();

        //String toastXPath="//*[@class='android.widget.Toast']";
        String toastXPath="//*[@package='com.android.settings']";
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastXPath))).getText());
        System.out.println(driver.findElementByXPath(toastXPath).getText());
        //System.out.println(locate(toastXPath).getText());
        for(int i =0;i <10;i++){
            int size=driver.findElementsByXPath(toastXPath).size();
            System.out.println(size);
            Thread.sleep(500);
        }

    }



    @Test
    public void testToast() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);


        Dimension screenSize=driver.manage().window().getSize();

        driver.findElementByAccessibilityId("Views").click();
        Thread.sleep(2000);
        (new TouchAction(driver))
                //.press( (int)(screenSize.width*0.5), (int)(screenSize.height*0.8))
                //.moveTo((int)(screenSize.width*0.5), (int)(screenSize.height*0.3))
                .release()
                .perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Popup Menu']"))).click();
        //driver.findElementByAccessibilityId("Popup Menu").click();
        driver.findElementByAccessibilityId("Make a Popup!").click();
        //locate("//*[contains(@text, 'MAKE')]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[contains(@text,'Search')]").click();

        String toastXPath="//*[@class='android.widget.Toast']";
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastXPath))));
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastXPath))).getText());
        System.out.println(driver.findElementByXPath(toastXPath).getText());
        //System.out.println(locate(toastXPath).getText());
        for(int i =0;i <10;i++){
            int size=driver.findElementsByXPath(toastXPath).size();
            System.out.println(size);
            Thread.sleep(500);
        }



    }



    @Test
    public void testToast2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Dimension screenSize=driver.manage().window().getSize();

        driver.findElementByAccessibilityId("Views").click();
        Thread.sleep(2000);
        (new TouchAction(driver))
                //.press( (int)(screenSize.width*0.5), (int)(screenSize.height*0.8))
                //.moveTo((int)(screenSize.width*0.5), (int)(screenSize.height*0.3))
                .release()
                .perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Popup Menu']"))).click();
        //driver.findElementByAccessibilityId("Popup Menu").click();
        driver.findElementByAccessibilityId("Make a Popup!").click();
        //locate("//*[contains(@text, 'MAKE')]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[contains(@text,'Search')]").click();

        String toastXPath="//*[@class='android.widget.Toast']";
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastXPath))));
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toastXPath))).getText());
        System.out.println(driver.findElementByXPath(toastXPath).getText());
        //System.out.println(locate(toastXPath).getText());
        for(int i =0;i <10;i++){
            int size=driver.findElementsByXPath(toastXPath).size();
            System.out.println(size);
            Thread.sleep(500);
        }

    }

    @Test
    public void testToast3() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", ".ApiDemos");
        caps.setCapability("deviceName", "xx");
        caps.setCapability("automationName", "uiautomator2");

        AndroidDriver driver=new AndroidDriver(new URL("http://192.168.31.99:4723/wd/hub"), caps);
        //System.out.println(driver.rotation().toString());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        findByXueqiu(driver, "//*[@text='Views']").click();
        findByXueqiu(driver,"new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().text(\"Popup Menu\"));").click();
        findByXueqiu(driver, "Make a Popup!").click();
        findByXueqiu(driver, "//*[@text='Search']").click();
        //System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
        System.out.println(driver.findElementByXPath("//*[@package='com.android.settings']").getText());


    }

    public WebElement findByXueqiu(AppiumDriver driver, String locator){
            return driver.findElementByXPath(locator);
        //todo: getPageSource返回xml
        //todo: 解析xml，解析出node的常见属性，text desc id
        //todo: 找当前界面所有的watch的元素，如果有弹框，广告，自动点击
        //todo: 根据正则或者其他的定位表达式找出匹配的node
        //todo: 根据确定的node，自动生成id accesi..id xpath android ios定位
        //todo: 重新确认元素位置是否发生变化
        //todo: 没有变化返回WebElement

    }


    @Test
    public void pageSource() throws InterruptedException {
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().text(\"Popup Menu\"));").click();
        driver.findElementByAccessibilityId("Make a Popup!").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Add']").click();
        for(int i=0;i<5;i++){
            System.out.println(driver.getPageSource());
            System.out.println("toast");
            System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
        }

        driver.quit();

    }

    @Test
    public void windowsAndContext() throws InterruptedException {
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"WebView\"));").click();

        System.out.println(driver.getContextHandles());
        driver.context("WEBVIEW_io.appium.android.apis");
        System.out.println(driver.getWindowHandles());

        driver.quit();

    }

}
