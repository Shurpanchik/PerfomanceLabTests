package pages.searchsites;

import elements.TextField;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Getter
@Setter
public class GoogleSearch extends Page {

    private static final Logger logger = LogManager.getLogger(GoogleSearch.class);

    @FindBy(id = "lst-ib")
    private TextField searchPanel;

    private String baseUrl;

    public GoogleSearch() {
        super("https://google.ru/");
    }

    public void sendSearch(String text){
        logger.info("Отправляем поисковой запрос: "+text);
        searchPanel.submitKeys(text);
    }
}
