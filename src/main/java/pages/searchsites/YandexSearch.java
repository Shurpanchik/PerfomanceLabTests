package pages.searchsites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSearch extends SearchPage {

    public YandexSearch(WebDriver driver) {
        super(driver);
        baseUrl = "https://yandex.ru/";
        searchPanel = By.cssSelector("#text");
    }
}
