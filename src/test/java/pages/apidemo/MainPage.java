package pages.apidemo;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.apidemo.ViewsPage;

public class MainPage {
    @AndroidFindBy(accessibility = "Views")
    WebElement views;

    WebElement text;

    public ViewsPage gotoViews(){
        views.click();
        ViewsPage viewsPage=new ViewsPage();
        return viewsPage;
    }

}
