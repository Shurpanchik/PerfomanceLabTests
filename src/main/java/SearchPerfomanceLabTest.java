import helpers.Driver;
import org.openqa.selenium.WebDriver;
import pages.perfomancelabsite.pages.AvtomatizacijaTestirovanijaPage;
import pages.perfomancelabsite.pages.SoftwareTestingPage;
import pages.perfomancelabsite.top.SubTopServices;
import pages.searchsites.GoogleSearch;
import pages.searchsites.RamblerSearch;
import pages.searchsites.SearchPage;
import pages.searchsites.YandexSearch;
import org.junit.Test;
import steps.PerfomanceLabSteps;
import steps.SearchSteps;

import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest extends TestSignatur {

    @Test
    public void SearchYandex() throws InterruptedException {
        writeArticle("yandex", new YandexSearch());
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        writeArticle("rambler", new RamblerSearch());
    }

    @Test
    public void SearchGoogle() throws InterruptedException {
        writeArticle("google", new GoogleSearch());
    }

    private void writeArticle(String fileName, SearchPage searchPage) {

        WebDriver driver = Driver.getInstance();
        PerfomanceLabSteps perfomanceLabSteps = new PerfomanceLabSteps();
        SearchSteps searchSteps = new SearchSteps(searchPage);

        // ищем ссылку на сайт perfomance lab в выдаче поиска
        searchSteps.searchPerfomanceLabLink();

        // подводим курсор к меню Продукты и услуги
        SubTopServices subTopServices = new SubTopServices();
        subTopServices.openSubTop();

        // в меню переходим в раздел тестирование
        perfomanceLabSteps.openElementMenu(subTopServices, subTopServices.getTesting());

        // переходим в меню Автоматизация тестирования

        SoftwareTestingPage softwareTestingPage = new SoftwareTestingPage();
        perfomanceLabSteps.openElementMenu(softwareTestingPage, softwareTestingPage.getServiceAutoTesting());

        // получаем весь текст из статьи
        AvtomatizacijaTestirovanijaPage avtomatizacijaTestirovanijaPage = new AvtomatizacijaTestirovanijaPage();
        perfomanceLabSteps.WriteArticleStep(
                Driver.getInstance().findElement(avtomatizacijaTestirovanijaPage.getArticle()).getText(),
                fileName);
    }
}
