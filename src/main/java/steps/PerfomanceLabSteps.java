package steps;

import helpers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Page;
import pages.perfomancelabsite.top.SubTopServices;

import java.io.FileWriter;
import java.io.IOException;

public class PerfomanceLabSteps {
    public PerfomanceLabSteps(){

    }
    public void OpenSubTop(){
        System.out.println("Открытие верхнего меню");
        SubTopServices subTopServices = new SubTopServices();
        subTopServices.openSubTop();
    }
    public  void openElementMenu (WebElement element){
        System.out.println("Выбираем пункт меню: " +element.getText());
        element.click();
    }

    public void WriteArticleStep(String text,String fileName){
        try {
            System.out.println("Записываем текст статьи в файл: "+fileName);
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
