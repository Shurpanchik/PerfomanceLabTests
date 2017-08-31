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
import pages.perfomancelabsite.top.SubTopServices;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public abstract class Page{

    public Page(String baseUrl) {
        this.openPage(baseUrl);
        page(this);
    }

    public void openLink(String text) {
        //getLog().info("Открываем ссылку с текстом: " + text);
        $(By.partialLinkText(text)).click();
    }

    public void openPage(String baseUrl){
        if (!url().contains(baseUrl)){
            open(baseUrl);
        }
    }
}
