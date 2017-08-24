package Pages.PerfomanceLabSite.Pages;

import Pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class AvtomatizacijaTestirovanijaPage extends Page {

    private By article;

    public AvtomatizacijaTestirovanijaPage(WebDriver driver) {
        super(driver);
        article = By.className("content-area");
    }

    public void writeArticle( String fileName, String text){
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
