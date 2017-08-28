package pages.searchsites;

import org.openqa.selenium.*;
import pages.Page;

//http://internetka.in.ua/selenium-page-object/
public abstract class SearchPage extends Page {

    protected String baseUrl;

    private WebElement searchPanel;

    public SearchPage(){
    }


    public void sendSearch(String text, WebElement searchPanel){
        System.out.println("Отправляем поисковой запрос: "+text);
        searchPanel.sendKeys(text);
        searchPanel.submit();
    }

    public void getBasePage(){
        getDriver().get(baseUrl);
    }


    public WebElement getSearchPanel() {
        return searchPanel;
    }
}
