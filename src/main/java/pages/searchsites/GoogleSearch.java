package pages.searchsites;

import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch extends SearchPage {

    @FindBy(css = "#lst-ib")
    TextField searchPanel;

    public GoogleSearch() {
        super();
        baseUrl = "https://google.ru/";
    }

    @Override
    public TextField getSearchPanel() {
        return searchPanel;
    }
}
