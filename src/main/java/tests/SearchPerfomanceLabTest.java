package tests;

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
        articleInPerfomanceFromSearchSteps.writeArticle("yandex", new YandexSearch());
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        articleInPerfomanceFromSearchSteps.writeArticle("rambler", new RamblerSearch());
    }

    @Test
    public void SearchGoogle() throws InterruptedException {
        articleInPerfomanceFromSearchSteps.writeArticle("google", new GoogleSearch());
    }

}
