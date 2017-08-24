package steps;

import org.openqa.selenium.WebDriver;
import pages.searchsites.SearchPage;

import static org.junit.Assert.fail;

public class SearchStep {
    public SearchStep(WebDriver driver,  SearchPage searchPage){
        // получаем стартовую страницу поиска
        searchPage.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        searchPage.sendSearch("perfomance lab");

        //находим ссылку сайта
        searchPage.openLink("Перфоманс Лаб - Услуги по тестированию");

        // так как сайт компании открывается в соседней вкладке, то переключимся на нее
        if (!browserobjects.Window.isOpenBlankLink(driver, 5, 1, 1)) {
            fail("В новом окне вкладка с сайтом perfomance lab не появилась");
        }
    }
}
