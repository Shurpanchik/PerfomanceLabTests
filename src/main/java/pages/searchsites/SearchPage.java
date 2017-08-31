package pages.searchsites;

import elements.Element;
import elements.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import pages.Page;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


//http://internetka.in.ua/selenium-page-object/
public abstract class SearchPage extends Page {

    protected String baseUrl;

    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    private TextField searchPanel;

    public SearchPage(){
    }


    public void sendSearch(String text, TextField searchPanel){
        logger.info("Отправляем поисковой запрос: "+text);
        searchPanel.submitKeys(text);
    }

    public void getBasePage(){
        getWebDriver().get(baseUrl);
    }


    public TextField getSearchPanel() {
        return searchPanel;
    }


}
