package pages.perfomancelabsite.top;

import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SubTopServices extends Page {


    private By root;

    private By testing;


    public SubTopServices(WebDriver driver) {
        super(driver);
        root = By.xpath("//*[@id=\"menu-item-317\"]/a");
        testing = By.cssSelector(".one_item_menu > div:nth-child(1) > li:nth-child(1) > a:nth-child(1)");
    }

    public void openSubTop(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(root)).build().perform();
    }

    public By getRoot() {
        return root;
    }

    public By getTesting() {
        return testing;
    }
}
