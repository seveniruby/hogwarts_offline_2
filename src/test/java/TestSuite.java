import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tags.冒烟测试;

@RunWith(Categories.class)
@Categories.IncludeCategory(冒烟测试.class)
@Suite.SuiteClasses({
        TestPageObject.class,
        TestPageObjectData.class
})
public class TestSuite {
}
