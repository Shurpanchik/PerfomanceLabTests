
import org.junit.Test;
import steps.PerfomanceLabSteps;
import steps.SearchSteps;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest extends tests.TestSignatur {

    @Test
    public void SearchYandex() throws InterruptedException {
        SearchSteps searchSteps = new SearchSteps();
        searchSteps.searchYandex();
        // так как сайт компании открывается в соседней вкладке, то переключимся на нее
        if (!browserobjects.Window.isOpenBlankLink(getWebDriver(), 5, 1, 1)) {
            fail("В новом окне вкладка с сайтом perfomance lab не появилась");
        }
        PerfomanceLabSteps perfomanceLabSteps = new PerfomanceLabSteps();
        perfomanceLabSteps.findArticle("yandex");
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        SearchSteps searchSteps = new SearchSteps();
        searchSteps.searchRambler();
        if (!browserobjects.Window.isOpenBlankLink(getWebDriver(), 5, 1, 1)) {
            fail("В новом окне вкладка с сайтом perfomance lab не появилась");
        }
        PerfomanceLabSteps perfomanceLabSteps = new PerfomanceLabSteps();
        perfomanceLabSteps.findArticle("rambler");
    }

    @Test
    public void SearchGoogle() throws InterruptedException {
        SearchSteps searchSteps = new SearchSteps();
        searchSteps.searchGoogle();
        if (!browserobjects.Window.isOpenBlankLink(getWebDriver(), 5, 1, 1)) {
            fail("В новом окне вкладка с сайтом perfomance lab не появилась");
        }
        PerfomanceLabSteps perfomanceLabSteps = new PerfomanceLabSteps();
        perfomanceLabSteps.findArticle("google");
    }

}
