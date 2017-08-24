package Pages.SearchSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch extends SearchPage {

    public GoogleSearch(WebDriver driver) {
        super(driver);
        baseUrl = "https://google.ru/";
        searchPanel = By.cssSelector("#lst-ib");
    }
}
