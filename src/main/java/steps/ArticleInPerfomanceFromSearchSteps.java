package steps;

import Listener.EventListener;
import elements.Element;
import helpers.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.perfomancelabsite.pages.AvtomatizacijaTestirovanijaPage;
import pages.perfomancelabsite.pages.SoftwareTestingPage;
import pages.perfomancelabsite.top.SubTopServices;
import pages.searchsites.SearchPage;

import static com.codeborne.selenide.Selenide.page;

public class ArticleInPerfomanceFromSearchSteps {
    private static final Logger logger = LogManager.getLogger(ArticleInPerfomanceFromSearchSteps .class);
    public void writeArticle(String fileName, SearchPage searchPage) {

        logger.info("Поиск ссылки perfomance lab и запись статьи в файл ");

        PerfomanceLabSteps perfomanceLabSteps = new PerfomanceLabSteps();
        SearchSteps searchSteps = new SearchSteps(searchPage);

        // ищем ссылку на сайт perfomance lab в выдаче поиска
        searchSteps.searchPerfomanceLabLink();

        // подводим курсор к меню Продукты и услуги
        SubTopServices subTopServices = page(SubTopServices.class);
        subTopServices.openSubTop();

        // в меню переходим в раздел тестирование
        perfomanceLabSteps.openElementMenu(subTopServices.getTesting());

        // переходим в меню Автоматизация тестирования

        SoftwareTestingPage softwareTestingPage = page(SoftwareTestingPage.class);
        perfomanceLabSteps.openElementMenu(softwareTestingPage.getServiceAutoTesting());

        // получаем весь текст из статьи
        AvtomatizacijaTestirovanijaPage avtomatizacijaTestirovanijaPage =
                page(AvtomatizacijaTestirovanijaPage.class);
        Element element = avtomatizacijaTestirovanijaPage.getArticle();
        perfomanceLabSteps.WriteArticleStep(
                avtomatizacijaTestirovanijaPage.getArticle().getText(),
                fileName);
    }
}
