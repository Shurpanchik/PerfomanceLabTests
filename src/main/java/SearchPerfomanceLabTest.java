import BrowserObjects.Window;
import Pages.PerfomanceLabSite.Pages.AvtomatizacijaTestirovanijaPage;
import Pages.PerfomanceLabSite.Pages.SoftwareTestingPage;
import Pages.PerfomanceLabSite.Top.SubTopServices;
import Pages.SearchSite.GoogleSearch;
import Pages.SearchSite.RamblerSearch;
import Pages.SearchSite.SearchPage;
import Pages.SearchSite.YandexSearch;
import Steps.TestSignatur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import sun.plugin.services.BrowserService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest extends TestSignatur {

    @Test
    public void SearchYandex() throws InterruptedException {
        writeArticle("yandex",new YandexSearch(driver) );
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        writeArticle("rambler", new RamblerSearch(driver));
    }
    @Test
    public void SearchGoogle() throws InterruptedException {
        writeArticle("google", new GoogleSearch(driver));
    }
    private void writeArticle(String fileName,SearchPage searchPage){
        // получаем стартовую страницу поиска
        searchPage.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        searchPage.sendSearch("perfomance lab");

        //находим ссылку сайта
        searchPage.openLink("Перфоманс Лаб - Услуги по тестированию");

        // так как сайт компании открывается в соседней вкладке, то переключимся на нее
        if(! BrowserObjects.Window.isOpenBlankLink(driver, 5, 1, 1)){
            fail("В новом окне вкладка с сайтом perfomance lab не появилась");
        }


        // подводим курсор к меню Продукты и услуги
        SubTopServices subTopServices = new SubTopServices(driver);
        subTopServices.openSubTop();

        // в меню переходим в раздел тестирование
        subTopServices.goToSectionTesting();

        // переходим в меню Автоматизация тестирования
        SoftwareTestingPage softwareTestingPage = new SoftwareTestingPage(driver);
        softwareTestingPage.goToAvtomatizacijaTestirovanijaPage();

        // получаем весь текст из статьи
        new AvtomatizacijaTestirovanijaPage(driver).writeArticle(fileName,driver.findElement(By.className("content-area")).getText() );
    }
}
