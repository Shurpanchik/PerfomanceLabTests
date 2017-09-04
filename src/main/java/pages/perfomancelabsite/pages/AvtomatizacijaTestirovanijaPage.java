package pages.perfomancelabsite.pages;

import elements.Element;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import pages.perfomancelabsite.top.SubTopServices;

@Getter
@Setter
public class AvtomatizacijaTestirovanijaPage extends Page {

    @FindBy(className = "content-area")
    private Element article;

    SubTopServices subTopServices;

    public AvtomatizacijaTestirovanijaPage() {
        super("http://www.performance-lab.ru/avtomatizacija-testirovanija");
        SubTopServices subTopServices = new SubTopServices();
    }

}
