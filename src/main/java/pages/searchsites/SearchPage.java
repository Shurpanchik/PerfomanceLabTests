package pages.searchsites;

import elements.TextField;
import org.openqa.selenium.*;
import pages.Page;

import static helpers.TestLogger.getLog;

//http://internetka.in.ua/selenium-page-object/
public abstract class SearchPage extends Page {

    protected String baseUrl;

    private TextField searchPanel;

    public SearchPage(){
    }


    public void sendSearch(String text, TextField searchPanel){
        getLog().info("Отправляем поисковой запрос: "+text);
        searchPanel.submitKeys(text);
    }

    public void getBasePage(){
        getDriver().get(baseUrl);
    }


    public TextField getSearchPanel() {
        return searchPanel;
    }


}
