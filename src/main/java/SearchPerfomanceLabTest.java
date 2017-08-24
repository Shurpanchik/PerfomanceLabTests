import BrowserObjects.Window;
import Pages.PerfomanceLabSite.Pages.AvtomatizacijaTestirovanijaPage;
import Pages.PerfomanceLabSite.Pages.SoftwareTestingPage;
import Pages.PerfomanceLabSite.Top.SubTopServices;
import Pages.SearchSite.SearchPage;
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
        driver.get("https://yandex.ru/");
        By searchPanel = By.cssSelector("#text");
        writeArticle("yandex", searchPanel);
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        driver.get("https://rambler.ru/");
        By searchPanel = By.cssSelector("#search_query");
        writeArticle("rambler", searchPanel);
    }
    @Test
    public void SearchGoogle() throws InterruptedException {
        driver.get("https://google.ru/");
        By searchPanel = By.cssSelector("#lst-ib");
        writeArticle("google", searchPanel);
    }
    private void writeArticle(String fileName, By searchPanel){
        SearchPage searchPage = new SearchPage(driver, searchPanel);

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
