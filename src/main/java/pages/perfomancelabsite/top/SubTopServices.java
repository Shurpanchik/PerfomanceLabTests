package pages.perfomancelabsite.top;

import elements.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static helpers.Driver.getDriver;
import static helpers.TestLogger.getLog;

public class SubTopServices extends Page {


    @FindBy(xpath = "//*[@id=\"menu-item-317\"]/a")
    private Element root;

    @FindBy(css =".one_item_menu > div:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
    private Element testing;


    public SubTopServices() {
        super();
    }

    public void openSubTop(){
        Actions actions = new Actions(getDriver());
        //actions.moveToElement(root).build().perform();
        root.click();
    }

    public Element getRoot() {
        return root;
    }

    public Element getTesting() {
        return testing;
    }
}
