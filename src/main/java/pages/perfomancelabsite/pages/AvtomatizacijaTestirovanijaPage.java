package pages.perfomancelabsite.pages;

import elements.Element;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

@Getter
@Setter
public class AvtomatizacijaTestirovanijaPage extends Page {

    @FindBy(className = "content-area")
    protected Element article;

    public AvtomatizacijaTestirovanijaPage() {
        super();
    }

}
