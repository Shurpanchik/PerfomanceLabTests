package pages;

import elements.Element;
import helpers.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class Page extends Driver {

    public  Page (){
        PageFactory.initElements(getWebDriver(), this);
    }
    public void openLink(String text){
        $(By.partialLinkText(text)).click();
    }
}
