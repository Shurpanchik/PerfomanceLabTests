package steps;

import ru.yandex.qatools.allure.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.searchsites.GoogleSearch;
import pages.searchsites.RamblerSearch;
import pages.searchsites.YandexSearch;


public class SearchSteps {
    private static final Logger logger = LogManager.getLogger(PerfomanceLabSteps.class);

    @Step
    public  void searchYandex(){
        YandexSearch yandexSearch = new YandexSearch();
        logger.info("Находим ссылку perfomance lab в поисковой выдаче");
        yandexSearch.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        yandexSearch.sendSearch("perfomance lab");

        //находим ссылку сайта
        yandexSearch.openLink("Перфоманс Лаб - Услуги по тестированию");


    }
    @Step
    public  void searchGoogle(){
        GoogleSearch googleSearch = new GoogleSearch();
        logger.info("Находим ссылку perfomance lab в поисковой выдаче");
        googleSearch.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        googleSearch.sendSearch("perfomance lab");

        //находим ссылку сайта
        googleSearch.openLink("Перфоманс Лаб - Услуги по тестированию");


    }
    @Step
    public  void searchRambler(){
        RamblerSearch ramblerSearch = new RamblerSearch();
        logger.info("Находим ссылку perfomance lab в поисковой выдаче");
        ramblerSearch.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        ramblerSearch.sendSearch("perfomance lab");

        //находим ссылку сайта
        ramblerSearch.openLink("Перфоманс Лаб - Услуги по тестированию");


    }
}
