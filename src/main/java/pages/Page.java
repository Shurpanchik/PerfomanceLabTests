package pages;

import helpers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static helpers.TestLogger.getLog;

public abstract class Page extends Driver {


    public  Page (){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void openLink(String text){
        getLog().info("Открываем ссылку с текстом: " +text);
        $(By.partialLinkText(text)).click();
    }
}
