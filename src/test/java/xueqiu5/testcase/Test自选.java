package xueqiu5.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hamcrest.CoreMatchers.*;
import xueqiu5.page.Page首页;
import xueqiu5.util.Driver;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.OrderingComparison.*;

public class Test自选 {
    @BeforeClass
    public static void beforeClass() throws MalformedURLException, InterruptedException {
        Driver.launch();
    }

    @Test
    public void test沪深股票() throws InterruptedException {
        Page首页 page首页=new Page首页();
        List<String> stocks=page首页.进入自选().get沪深股票();
        assertThat(stocks.size(), greaterThan(5));
    }
}
