package xueqiu6.testcase;

import org.hamcrest.Matchers;
import org.junit.After;
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
public class 股票搜索Test {

    Page搜索 page搜索;
    @Parameterized.Parameters(name = "{1}")
    public static Object[][] data(){
        return new Object[][]{
                {"PDD", "拼多多"},
                {"sogo", "搜狗"},
                {"xiaomi", "小米集团-W"},
                {"pingan", "平安公司"}
        };
    }

    @Parameterized.Parameter
    public String keyword;
    @Parameterized.Parameter(1)
    public String name;

    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        AppDriver.launchApp();
    }
    @AfterClass
    public static void afterClass(){
        AppDriver.quit();
    }
    @After
    public void after(){
        page搜索.enterXueqiu();
    }

    @Test
    public void search(){
        Page雪球 page雪球=new Page雪球();
        page搜索=page雪球.enterSearch();
        assertThat(
                page搜索.search(keyword).getStockNames().get(0),
                Matchers.equalTo(name));

    }
}
