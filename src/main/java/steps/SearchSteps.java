package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.searchsites.GoogleSearch;
import pages.searchsites.RamblerSearch;
import pages.searchsites.YandexSearch;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.fail;

public class SearchSteps {
    private static final Logger logger = LogManager.getLogger(PerfomanceLabSteps.class);

    public  void searchYandex(){
        YandexSearch yandexSearch = page(YandexSearch.class);
        logger.info("Находим ссылку perfomance lab в поисковой выдаче");
        yandexSearch.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        yandexSearch.sendSearch("perfomance lab");

        //находим ссылку сайта
        yandexSearch.openLink("Перфоманс Лаб - Услуги по тестированию");


    }

    public  void searchGoogle(){
        GoogleSearch googleSearch = page(GoogleSearch.class);
        logger.info("Находим ссылку perfomance lab в поисковой выдаче");
        googleSearch.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        googleSearch.sendSearch("perfomance lab");

        //находим ссылку сайта
        googleSearch.openLink("Перфоманс Лаб - Услуги по тестированию");


    }
    public  void searchRambler(){
        RamblerSearch ramblerSearch = page(RamblerSearch.class);
        logger.info("Находим ссылку perfomance lab в поисковой выдаче");
        ramblerSearch.getBasePage();
        // отправляем поисковый запрос перфоманс лаб
        ramblerSearch.sendSearch("perfomance lab");

        //находим ссылку сайта
        ramblerSearch.openLink("Перфоманс Лаб - Услуги по тестированию");


    }
}
