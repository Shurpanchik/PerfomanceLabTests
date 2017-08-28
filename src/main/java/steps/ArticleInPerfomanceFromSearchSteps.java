package steps;

import helpers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.perfomancelabsite.pages.AvtomatizacijaTestirovanijaPage;
import pages.perfomancelabsite.pages.SoftwareTestingPage;
import pages.perfomancelabsite.top.SubTopServices;
import pages.searchsites.SearchPage;

import static helpers.TestLogger.getLog;

public class ArticleInPerfomanceFromSearchSteps {
    public void writeArticle(String fileName, SearchPage searchPage) {

        getLog().info("Поиск ссылки perfomance lab и запись статьи в файл ");

        PerfomanceLabSteps perfomanceLabSteps = new PerfomanceLabSteps();
        SearchSteps searchSteps = new SearchSteps(searchPage);

        // ищем ссылку на сайт perfomance lab в выдаче поиска
        searchSteps.searchPerfomanceLabLink();

        // подводим курсор к меню Продукты и услуги
        SubTopServices subTopServices = new SubTopServices();
        subTopServices.openSubTop();

        // в меню переходим в раздел тестирование
        perfomanceLabSteps.openElementMenu(subTopServices.getTesting());

        // переходим в меню Автоматизация тестирования

        SoftwareTestingPage softwareTestingPage = new SoftwareTestingPage();
        perfomanceLabSteps.openElementMenu(softwareTestingPage.getServiceAutoTesting());

        // получаем весь текст из статьи
        AvtomatizacijaTestirovanijaPage avtomatizacijaTestirovanijaPage =
                new AvtomatizacijaTestirovanijaPage();
        WebElement element = avtomatizacijaTestirovanijaPage.getArticle();
        perfomanceLabSteps.WriteArticleStep(
                avtomatizacijaTestirovanijaPage.getArticle().getText(),
                fileName);
    }
}
