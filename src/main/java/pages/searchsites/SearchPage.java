package pages.searchsites;

import org.openqa.selenium.*;
import pages.Page;

//http://internetka.in.ua/selenium-page-object/
public abstract class SearchPage extends Page {


    protected By searchPanel;

    protected String baseUrl;

    public SearchPage(){
    }


    public void sendSearch(String text){
        driver.findElement(searchPanel).sendKeys(text);
        driver.findElement(searchPanel).submit();
    }

    public void openLink(String text){
       driver.findElement(By.partialLinkText(text)).click();
    }

    public void getBasePage(){
        driver.get(baseUrl);
    }
}
