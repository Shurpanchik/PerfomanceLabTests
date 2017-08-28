package steps;

import org.openqa.selenium.WebDriver;
import pages.searchsites.SearchPage;

import static helpers.Driver.getDriver;
import static helpers.TestLogger.getLog;
import static org.junit.Assert.fail;

public class SearchSteps {
    SearchPage searchPage;
    public SearchSteps(SearchPage searchPage){
        this.searchPage = searchPage;
    }


    public void searchPerfomanceLabLink(){
        getLog().info("Находим ссылку perfomance lab в поисковой выдаче");
        searchPage.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        searchPage.sendSearch("perfomance lab", searchPage.getSearchPanel());

        //находим ссылку сайта
        searchPage.openLink("Перфоманс Лаб - Услуги по тестированию");

        // так как сайт компании открывается в соседней вкладке, то переключимся на нее
        if (!browserobjects.Window.isOpenBlankLink(getDriver(), 5, 1, 1)) {
            fail("В новом окне вкладка с сайтом perfomance lab не появилась");
        }
    }
}
