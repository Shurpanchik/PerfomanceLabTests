

import pages.searchsites.GoogleSearch;
import pages.searchsites.RamblerSearch;
import pages.searchsites.YandexSearch;
import org.junit.Test;

import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest extends tests.TestSignatur {

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
