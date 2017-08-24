import pages.perfomancelabsite.pages.AvtomatizacijaTestirovanijaPage;
import pages.perfomancelabsite.pages.SoftwareTestingPage;
import pages.perfomancelabsite.top.SubTopServices;
import pages.searchsites.GoogleSearch;
import pages.searchsites.RamblerSearch;
import pages.searchsites.SearchPage;
import pages.searchsites.YandexSearch;
import org.junit.Test;
import steps.OpenElementMenuStep;
import steps.SearchStep;
import steps.WriteArticleStep;

import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest extends TestSignatur {

    @Test
    public void SearchYandex() throws InterruptedException {
        writeArticle("yandex", new YandexSearch(driver));
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        writeArticle("rambler", new RamblerSearch(driver));
    }

    @Test
    public void SearchGoogle() throws InterruptedException {
        writeArticle("google", new GoogleSearch(driver));
    }

    private void writeArticle(String fileName, SearchPage searchPage) {

        SearchStep searchStep = new SearchStep(driver, searchPage);

        // подводим курсор к меню Продукты и услуги
        SubTopServices subTopServices = new SubTopServices(driver);
        subTopServices.openSubTop();

        // в меню переходим в раздел тестирование
        new OpenElementMenuStep(driver, subTopServices.getTesting());

        // переходим в меню Автоматизация тестирования
        new OpenElementMenuStep(driver, new SoftwareTestingPage(driver).getServiceAutoTesting());

        // получаем весь текст из статьи
        new WriteArticleStep(
                driver.findElement(new AvtomatizacijaTestirovanijaPage(driver).getArticle()).getText(), fileName);
    }
}
