package pages.perfomancelabsite.top;

import Listener.EventListener;
import com.codeborne.selenide.ElementsCollection;
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

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
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

    /**
     * Метод получения элемента в выпадающем меню
     * @param topItem
     * @param subTopItem
     * @return
     */
    public WebElement getMenuTopItem(String topItem, String subTopItem){
        try {
            $(By.id("nav"))
                    .$(By.partialLinkText(topItem)).click();

            List<WebElement> webElements = $(By.id("nav")).findElements(By.tagName("li"));

            WebElement top = null;

            for (int i = 0; i < webElements.size(); i++) {
                try {
                    System.out.println(webElements.get(i).findElement(By.tagName("a")).getText().toLowerCase());
                    if (webElements.get(i).findElement(By.tagName("a")).getText().toLowerCase()
                            .equals(topItem.toLowerCase())) {
                        top = webElements.get(i).findElement(By.className("sub-menu"));
                        top = $(By.cssSelector(".one_item_menu"));
                        return  getSubTop(top, subTopItem);
                    }
                } catch (Exception exx) {
                    continue;
                }
            }
            top = $(By.cssSelector(".one_item_menu"));
            return getSubTop(top, subTopItem);
        }
        catch (Exception exx){
            return null;
        }
    }

    /**
     * поиск название подраздела
     * @param container
     * @param subTopItem
     * @return
     */
    private WebElement getSubTop(WebElement container, String subTopItem) {
        try {
            List<WebElement> webElements = container
                    .findElements(By.tagName("li"));

            WebElement element = null;

            for (int i = 0; i < webElements.size(); i++) {
                try {
                    System.out.println(webElements.get(i).findElement(By.tagName("a")).getText().toLowerCase());
                    if (webElements.get(i).findElement(By.tagName("a")).getText().toLowerCase()
                            .equals(subTopItem.toLowerCase())) {
                        return webElements.get(i).findElement(By.tagName("a"));
                    }
                } catch (Exception exx) {
                    continue;
                }
            }
            return element;
        }
        catch(Exception exx){
            return null;
        }
    }
}
