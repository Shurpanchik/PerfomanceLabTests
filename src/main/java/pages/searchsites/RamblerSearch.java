package pages.searchsites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerSearch extends  SearchPage {

    @FindBy(css = "#search_query")
    WebElement searchPanel;

    public RamblerSearch() {
        super();
        baseUrl ="https://rambler.ru/";
    }

    @Override
    public WebElement getSearchPanel() {
        return searchPanel;
    }
}
