package pages.searchsites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch extends SearchPage {

    public GoogleSearch() {
        super();
        baseUrl = "https://google.ru/";
        searchPanel = By.cssSelector("#lst-ib");
    }
}
