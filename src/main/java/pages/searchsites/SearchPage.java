package pages.searchsites;

import org.openqa.selenium.*;

//http://internetka.in.ua/selenium-page-object/
public abstract class SearchPage {

    protected WebDriver driver;

    protected By searchPanel;

    protected String baseUrl;

    public SearchPage(WebDriver driver){
        this.driver = driver;
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
