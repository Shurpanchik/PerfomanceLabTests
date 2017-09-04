package steps;

import Listener.EventListener;
import elements.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import pages.perfomancelabsite.pages.AvtomatizacijaTestirovanijaPage;
import pages.perfomancelabsite.pages.SoftwareTestingPage;
import pages.perfomancelabsite.top.SubTopServices;

import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;


public class PerfomanceLabSteps {

    private static final Logger logger = LogManager.getLogger(PerfomanceLabSteps.class);

    public PerfomanceLabSteps(){

    }
    public  void openElementMenu (Element element){
        element.click();
    }

    public void writeArticleStep(String text,String fileName){
        try {
            logger.info("Записываем текст статьи в файл: "+fileName);
            FileWriter writer = new FileWriter(fileName, false);
            try {
                writer.write(text);
                writer.flush();
            } finally {
                writer.close();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param fileName - это название файла, в который запишется текст статьи
     */
    public void findArticle(String fileName) {

        // подводим курсор к меню Продукты и услуги
        SubTopServices subTopServices = page(SubTopServices.class);
        subTopServices.openSubMenu("Услуги и продукты");

        // в меню переходим в раздел тестирование
        WebElement menu = subTopServices.getMenuTopItem("Услуги и продукты", "ТЕСТИРОВАНИЕ");
        menu.click();

        // переходим в меню Автоматизация тестирования

        SoftwareTestingPage softwareTestingPage = page(SoftwareTestingPage.class);
        openElementMenu(softwareTestingPage.getServiceAutoTesting());

        // получаем весь текст из статьи
        AvtomatizacijaTestirovanijaPage avtomatizacijaTestirovanijaPage =
                page(AvtomatizacijaTestirovanijaPage.class);
        Element element = avtomatizacijaTestirovanijaPage.getArticle();
        writeArticleStep(
                avtomatizacijaTestirovanijaPage.getArticle().getText(),
                fileName);
    }
}
