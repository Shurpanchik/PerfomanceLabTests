package Pages.SearchSite;

import org.openqa.selenium.*;

import java.util.List;

//http://internetka.in.ua/selenium-page-object/
public class SearchPage {

    private WebDriver driver;

    private By searchPanel;

    public SearchPage(WebDriver driver, By searchPanel){
        this.driver = driver;
        this.searchPanel = searchPanel;
    }


    public void sendSearch(String text){
        driver.findElement(searchPanel).sendKeys(text);
        driver.findElement(searchPanel).submit();
    }

    public void openLink(String text){
       driver.findElement(By.partialLinkText(text)).click();
    }
}
