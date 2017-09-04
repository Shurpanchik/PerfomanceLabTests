
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.perfomancelabsite.top.SubTopServices;
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

    @Test
    public void  openElementSubMenuServiciesAndProducts(){
        getWebDriver().get("http://www.performance-lab.ru");
        SubTopServices subTopServices = page(SubTopServices.class);
        subTopServices.openSubMenu("Услуги и продукты");
        SelenideElement menu = subTopServices.getMenuTopItem("Услуги и продукты", "ТЕСТИРОВАНИЕ");
        menu.click();
    }
    @Test
    public void  openElementSubMenuVacancies(){
        getWebDriver().get("http://www.performance-lab.ru");
        SubTopServices subTopServices = page(SubTopServices.class);
        subTopServices.openSubMenu("Вакансии");
        SelenideElement menu = subTopServices.getMenuTopItem("Вакансии", "Карьера в перфоманс лаб");
        menu.click();
    }
}
