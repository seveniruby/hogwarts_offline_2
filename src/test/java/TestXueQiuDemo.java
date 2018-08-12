import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tags.冒烟测试;
import tags.行情;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.rmi.Remote;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;


public class TestXueQiuDemo {
    private static AndroidDriver<AndroidElement> driver;

    private static RemoteWebDriver chromedriver;
    static String apiPackage="io.appium.android.apis";
    static String apiActivity=".ApiDemos";


    @BeforeClass
    public static void beforeClass() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/2.20");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void beforeXueqiu() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        //capabilities.setCapability("automationName", "uiautomator2");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }



    public static void beforeChrome() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "ddd");
        capabilities.setCapability("browserName", "Browser");
        //capabilities.setCapability("automationName", "uiautomator2");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


    public static void beforeAndroidChrome() throws MalformedURLException {

        DesiredCapabilities chromeOptions = DesiredCapabilities.chrome();
        chromeOptions.setCapability("androidPackage", apiPackage);
        chromeOptions.setCapability("androidUseRunningApp", true);
        chromeOptions.setCapability("androidProcess", apiPackage);

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("dontStopAppOnReset", true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromedriver=new RemoteWebDriver(new URL("http://127.0.0.1:8000/wd/hub"), chromeOptions);

    }

    public static void beforeMacChrome() throws MalformedURLException {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("androidPackage", apiPackage);
        capabilities.setCapability("androidUseRunningApp", true);
        capabilities.setCapability("androidProcess", apiPackage);

        chromedriver=new RemoteWebDriver(new URL("http://127.0.0.1:8000/wd/hub"), capabilities);

    }


    @Test
    public void demo() throws InterruptedException {
        Thread.sleep(5000);
        locate("//*[@text='自选']").click();
        Thread.sleep(2000);
        locate("//*[@text='美股']").click();
        Thread.sleep(5000);
        locate("action_create_cube").click();
        locate("search_input_text").sendKeys("ali");
    }

    @Test
    public void testScroll() throws InterruptedException {
        Thread.sleep(5000);
        locate("//*[@text='自选']");

        //(new TouchAction(driver)).press(100, 200).waitAction().moveTo(300, 400).release().perform();
    }

    @Test
    public void testScrollNew() throws InterruptedException {
        Thread.sleep(5000);

        System.out.println(locate("//*[@text='自选']").getAttribute("resource-id"));
        locate("//*[@text='自选2']");


        TouchActions action = new TouchActions(driver);
        action.scroll(locate("//*[@text='房产']"), 300, 400);
        action.perform();
    }


    @Category({冒烟测试.class, 行情.class})
    @Test
    public void testscreenshot() throws IOException {
        driver.findElementByAccessibilityId("Views").click();
        saveScreen();
        //System.out.println(driver.startRecordingScreen());
        driver.findElementByAccessibilityId("Buttons").click();
        //System.out.println(driver.stopRecordingScreen());

    }

    @Test
    public void testNotStop() throws InterruptedException {
        for(AndroidElement e: driver.findElementsByXPath("//*")){
            System.out.println(e.getText());
        }
        //driver.findElementByAccessibilityId("Buttons");
        Thread.sleep(20000);
    }


    public void saveScreen() throws IOException {
        File f1=new File(System.currentTimeMillis()+".png");
        File f2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f2, f1);
    }

    @Test
    public void testWeb() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Test
    public void testScrollLeft() throws InterruptedException {
        System.out.println(driver.findElementByXPath("//*[@text='自选']").getLocation());
        Thread.sleep(5000);
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;

/*
        driver.performTouchAction(
                new TouchAction(driver)
                        .press((int)(width * 0.5), (int)(height * 0.5))
                        .waitAction(Duration.ofSeconds(1))
                        //.moveTo((screenWidth * (endX-startX)).toInt, (screenHeight * (endY-startY)).toInt)
                        .moveTo( (int)(width * 0.5), (int)(height * 0.9))
                        .release()
        );*/

        Thread.sleep(5000);

        (new TouchAction(driver))
                //.press((int)(width * 0.5), (int)(height * 0.5)).waitAction()
                //.waitAction(Duration.ofSeconds(1))
                //.moveTo((int)(width*0.5), (int)(height*0.8))
                //.waitAction(Duration.ofSeconds(2))
                .release().perform();
        WebDriverWait wait=new WebDriverWait(driver, 10);
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '更新')]"))).getText());

    };




    @Test
    public void testWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//*[@text='自选']").click();
    }
    @Test
    public void testWait2(){
        WebDriverWait wait=new WebDriverWait(driver, 10);
        for(int i=0;i<10;i++) {
            System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='自选']"))).getLocation());
        }
        driver.findElementByXPath("//*[@text='自选']").click();
    }


    @Test
    public void testRotate() throws InterruptedException {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElementByXPath("//*[@text='App']").click();
        driver.navigate().back();
        //driver.openNotifications();
        Thread.sleep(10000);
    }
    @Test
    public void testLogs(){
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        for(Object l : driver.manage().logs().get("logcat").getAll().toArray()){
            System.out.println(l);
        }
    }

    @Test
    public void testPerformance() throws Exception {
        System.out.println(driver.getSupportedPerformanceDataTypes());
        System.out.println(driver.getPerformanceData("io.appium.android.apis", "memoryinfo", 10));
        System.out.println(driver.getPerformanceData("io.appium.android.apis", "cpuinfo", 10));
        System.out.println(driver.getPerformanceData("io.appium.android.apis", "batteryinfo", 10));
        System.out.println(driver.getPerformanceData("io.appium.android.apis", "networkinfo", 10));
    }

    @Test
    public void testScrollTo(){
        driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = driver.findElement(By.id("android:id/list"));
        MobileElement radioGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"Radio Group\"));"));
        assertNotNull(radioGroup.getLocation());
    }


    @Test
    public void testWebView() throws InterruptedException {
        Thread.sleep(6000);
        driver.findElementByXPath("//*[@text='跳过']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='交易']").click();
        Thread.sleep(3000);
            System.out.println(driver.getContextHandles());
            Thread.sleep(1000);
            System.out.println(driver.getPageSource());
            driver.getContextHandles().forEach(context->{
                if(context.contains("WEBVIEW")){
                    System.out.println(context);
                    driver.context(context);
                    System.out.println(driver.getPageSource());
                }
            });
    }

    @Test
    public void testChromeDriverOrigin() throws MalformedURLException, InterruptedException {
        System.out.println(chromedriver.getPageSource());
        chromedriver.get("http://www.baidu.com");
        System.out.println(chromedriver.getPageSource());
    }






    public AndroidElement locate(String locator){
            if (locator.matches("\\/\\/.*")) {
                System.out.println("xpath");
                return driver.findElementByXPath(locator);
            } else {
                System.out.println("id");
                return driver.findElementById(locator);
            }
    }
    @After
    public void teardown(){
        //driver.quit();
    }
}
