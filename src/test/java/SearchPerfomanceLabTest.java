
import pages.searchsites.GoogleSearch;
import pages.searchsites.RamblerSearch;
import pages.searchsites.YandexSearch;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest extends tests.TestSignatur {

    @Test
    public void SearchYandex() throws InterruptedException {
        articleInPerfomanceFromSearchSteps.writeArticle("yandex", page(YandexSearch.class));
    }

    @Test
    public void SearchRambler() throws InterruptedException {

        articleInPerfomanceFromSearchSteps.writeArticle("rambler", page(RamblerSearch.class));
    }

    @Test
    public void SearchGoogle() throws InterruptedException {
        articleInPerfomanceFromSearchSteps.writeArticle("google", page(GoogleSearch.class));
    }

}
