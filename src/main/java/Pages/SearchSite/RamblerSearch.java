package Pages.SearchSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RamblerSearch extends  SearchPage {
    public RamblerSearch(WebDriver driver) {
        super(driver);
        searchPanel = By.cssSelector("#search_query");
        baseUrl ="https://rambler.ru/";
    }
}
