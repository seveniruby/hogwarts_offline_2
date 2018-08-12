import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestChrome {
    @Test
    public void headless() throws IOException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("headless");
        //chromeOptions.addArguments("window-size=400,1024");
        //chromeOptions.addArguments("user-agent=\"Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36\"");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com");
        //driver.findElement(By.className("input"));
        FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("3.png"));
    }


    @Test
    public void chrome() throws IOException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        ChromeOptions chromeOptions=new ChromeOptions();
        //chromeOptions.addArguments("headless");
        //chromeOptions.addArguments("window-size=400,1024");
        //chromeOptions.addArguments("user-agent=\"Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36\"");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:5555/wd/hub"), capabilities);
        //ChromeDriver chromeDriver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com");
        FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("1.png"));
    }

    @Test
    public void ieByGrid() throws IOException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //chromeOptions.addArguments("headless");
        //chromeOptions.addArguments("window-size=400,1024");
        //chromeOptions.addArguments("user-agent=\"Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36\"");
        //capabilities.setCapability(DesiredCapabilities., chromeOptions);
        capabilities.setBrowserName("browser");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "demo");
        capabilities.setCapability("chromedriverExecutableDir", "/Users/seveniruby/projects/chromedriver/2.20");


        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.31.99:4444/wd/hub"), capabilities);
        //ChromeDriver chromeDriver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com");
        FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("2.png"));
    }

}
