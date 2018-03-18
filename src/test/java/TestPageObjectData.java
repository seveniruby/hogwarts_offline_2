import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.MainActivity;
import pages.Welcome;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestPageObjectData {
    static AndroidDriver<AndroidElement> driver;

    @Parameterized.Parameters
    public static List<String[]> data(){
        return Arrays.asList(new String[][]{
                {"b", "8.0"},
                {"c", "6.0"}
        });
        //todo: from file xml excel
    }
    @Parameterized.Parameter
    public String deviceName;
    @Parameterized.Parameter(1)
    public String version;

    @Before
    public void before() throws MalformedURLException {
        System.out.println(deviceName);
        System.out.println(version);
        //System.out.println(System.getenv("deviceName"));
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("", "");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("deviceName", deviceName);
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

        //welcome.跳过欢迎页();
        //main.自选.click();

        //todo: 定位需要自己定制，而不能照搬原有的注解，不然动态加载就会引发不稳定
    }
}


