package pages.perfomancelabsite.pages;

import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class AvtomatizacijaTestirovanijaPage extends Page {


    private By article;

    public AvtomatizacijaTestirovanijaPage(WebDriver driver) {
        super();
        article = By.className("content-area");
    }

    public By getArticle() {
        return article;
    }
}
