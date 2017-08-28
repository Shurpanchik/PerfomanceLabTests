package pages.perfomancelabsite.top;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SubTopServices extends Page {


    @FindBy(xpath = "//*[@id=\"menu-item-317\"]/a")
    private WebElement root;

    @FindBy(css =".one_item_menu > div:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
    private WebElement testing;


    public SubTopServices() {
        super();
    }

    public void openSubTop(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(root).build().perform();
    }

    public WebElement getRoot() {
        return root;
    }

    public WebElement getTesting() {
        return testing;
    }
}
