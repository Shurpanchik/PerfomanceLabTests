package pages.searchsites;

import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerSearch extends  SearchPage {

    @FindBy(css = "#search_query")
    TextField searchPanel;

    public RamblerSearch() {
        super();
        baseUrl ="https://rambler.ru/";
    }

    @Override
    public TextField getSearchPanel() {
        return searchPanel;
    }
}
