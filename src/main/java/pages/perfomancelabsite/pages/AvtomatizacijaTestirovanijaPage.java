package pages.perfomancelabsite.pages;

import elements.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class AvtomatizacijaTestirovanijaPage extends Page {

    @FindBy(className = "content-area")
    private Element article;

    public AvtomatizacijaTestirovanijaPage() {
        super();
    }

    public Element getArticle() {
        return article;
    }
}
