package steps;

import helpers.Driver;
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
    public  void openElementMenu (By element){
        Driver.getInstance().findElement(element).click();
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

    public String getText(By element){
       return Driver.getInstance().findElement(element).getText();
    }
}
