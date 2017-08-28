package pages.searchsites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexSearch extends SearchPage {

    @FindBy(css = "#text")
    WebElement searchPanel;

    public YandexSearch() {
        super();
        baseUrl = "https://yandex.ru/";
    }

    @Override
    public WebElement getSearchPanel() {
        return searchPanel;
    }
}
