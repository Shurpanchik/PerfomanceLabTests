package pages.searchsites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RamblerSearch extends  SearchPage {
    public RamblerSearch() {
        super();
        searchPanel = By.cssSelector("#search_query");
        baseUrl ="https://rambler.ru/";
    }
}
