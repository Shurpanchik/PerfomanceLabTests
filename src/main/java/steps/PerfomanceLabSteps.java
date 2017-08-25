package steps;

import org.openqa.selenium.By;
import pages.Page;
import pages.perfomancelabsite.top.SubTopServices;

import java.io.FileWriter;
import java.io.IOException;

public class PerfomanceLabSteps {
    public PerfomanceLabSteps(){

    }
    public void OpenSubTop(){
        SubTopServices subTopServices = new SubTopServices();
        subTopServices.openSubTop();
    }
    public  void openElementMenu (Page page, By element){
        page.getDriver().findElement(element).click();
    }

    public void WriteArticleStep(String text,String fileName){
        try {
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
