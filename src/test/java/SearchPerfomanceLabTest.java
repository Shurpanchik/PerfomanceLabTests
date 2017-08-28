

import helpers.Driver;
import org.openqa.selenium.support.PageFactory;
import pages.perfomancelabsite.top.SubTopServices;
import pages.searchsites.GoogleSearch;
import pages.searchsites.RamblerSearch;
import pages.searchsites.YandexSearch;
import org.junit.Test;

import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest extends tests.TestSignatur {

    @Test
    public void SearchYandex() throws InterruptedException {
        articleInPerfomanceFromSearchSteps.writeArticle("yandex",
                PageFactory.initElements(Driver.getDriver(), YandexSearch.class));
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        articleInPerfomanceFromSearchSteps.writeArticle("rambler",
                PageFactory.initElements(Driver.getDriver(), RamblerSearch.class));
    }

    @Test
    public void SearchGoogle() throws InterruptedException {
        articleInPerfomanceFromSearchSteps.writeArticle("google",
                PageFactory.initElements(Driver.getDriver(),GoogleSearch.class));
    }

}
