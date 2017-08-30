package steps;

import org.openqa.selenium.WebElement;
import pages.perfomancelabsite.top.SubTopServices;

import java.io.FileWriter;
import java.io.IOException;

import static helpers.TestLogger.getLog;

public class PerfomanceLabSteps {
    public PerfomanceLabSteps(){

    }
    public void OpenSubTop(){
        getLog().info("Открытие верхнего меню");
        SubTopServices subTopServices = new SubTopServices();
        subTopServices.openSubTop();
    }
    public  void openElementMenu (WebElement element){
        getLog().info("Выбираем пункт меню: " +element.getText());
        element.click();
    }

    public void WriteArticleStep(String text,String fileName){
        try {
            getLog().info("Записываем текст статьи в файл: "+fileName);
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
}
