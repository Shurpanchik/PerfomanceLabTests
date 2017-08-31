package pages.perfomancelabsite.top;

import Listener.EventListener;
import elements.Element;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Getter
@Setter
public class SubTopServices {

    private static final Logger logger = LogManager.getLogger(SubTopServices.class);

    @FindBy(xpath = "//*[@id=\"menu-item-317\"]/a")
    private Element root;

    @FindBy(css =".one_item_menu > div:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
    private Element testing;


    public SubTopServices() {
        super();
    }

    public void openSubTop(){
        Actions actions = new Actions(getWebDriver());
        //actions.moveToElement(root).build().perform();
        root.click();
    }

}
