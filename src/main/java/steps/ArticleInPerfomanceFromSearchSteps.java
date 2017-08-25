package steps;

import pages.perfomancelabsite.pages.AvtomatizacijaTestirovanijaPage;
import pages.perfomancelabsite.pages.SoftwareTestingPage;
import pages.perfomancelabsite.top.SubTopServices;
import pages.searchsites.SearchPage;

public class ArticleInPerfomanceFromSearchSteps {
    public void writeArticle(String fileName, SearchPage searchPage) {

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
        AvtomatizacijaTestirovanijaPage avtomatizacijaTestirovanijaPage = new AvtomatizacijaTestirovanijaPage();
        perfomanceLabSteps.WriteArticleStep(
                perfomanceLabSteps.getText(avtomatizacijaTestirovanijaPage.getArticle()),
                fileName);
    }
}
