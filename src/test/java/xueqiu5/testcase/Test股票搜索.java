package xueqiu5.testcase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import xueqiu5.page.Page首页;
import xueqiu5.util.Driver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class Test股票搜索 {

    @Parameterized.Parameters
    public static List<String[]> data(){
        return Arrays.asList(new String[][]{
                {"PDD", "拼多多"},
                {"SOGO", "搜狗"}
        });
    }

    @Before
    public void before() throws MalformedURLException, InterruptedException {
        Driver.relaunch();
    }


    @Parameterized.Parameter(0)
    public String key;
    @Parameterized.Parameter(1)
    public String name;

    @Test
    public void 搜索股票() throws InterruptedException {
        Page首页 page首页=new Page首页();
        List<String> stocks=page首页.进入搜索().search(key).getStockList();
        assertThat(stocks.get(0), equalTo(name) );

    }
}
