package pages.perfomancelabsite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;

public class AvtomatizacijaTestirovanijaPage extends Page {

    @FindBy(className = "content-area")
    private WebElement article;

    public AvtomatizacijaTestirovanijaPage() {
        super();
    }

    public WebElement getArticle() {
        return article;
    }
}
