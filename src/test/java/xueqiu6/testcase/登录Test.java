package xueqiu6.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import xueqiu6.pages.Page搜索;
import xueqiu6.pages.Page雪球;
import xueqiu6.utils.AppDriver;

import java.net.MalformedURLException;

import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class 登录Test {

    Page搜索 page搜索;
    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"15600534760", "xueqiu12345678"}
        };
    }

    @Parameterized.Parameter
    public String phone;
    @Parameterized.Parameter(1)
    public String password;

    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        AppDriver.launchApp();
    }
    @AfterClass
    public static void afterClass(){
        AppDriver.quit();
    }

    @Test
    public void login(){
        Page雪球 page雪球=new Page雪球();
        page雪球.enterLogin().enterLogin().login(phone, password);

    }
}
