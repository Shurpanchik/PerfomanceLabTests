package pages.searchsites;

import elements.TextField;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class GoogleSearch extends SearchPage {

    @FindBy(id = "lst-ib")
    TextField searchPanel;

    public GoogleSearch() {
        super();
        baseUrl = "https://google.ru/";
    }
}
