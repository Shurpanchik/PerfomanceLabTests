package pages.perfomancelabsite.top;

import elements.Element;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
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

    /**
     * Метод получения элемента в выпадающем меню по названию меню и названию элемента подменю
     * @param topItem
     * @param subTopItem
     * @return
     */
    public WebElement getMenuTopItem(String topItem, String subTopItem){
        try {
            String topLocator = getCSSLocatorSubMenu(topItem);
            WebElement top = $(By.cssSelector(topLocator));

            return getSubTopElement(top, subTopItem);
        }
        catch (Exception exx){
            return null;
        }
    }

    /**
     * получение элемента на выпадающей панели по панеле и названию пункта меню
     * @param container
     * @param subTopItem
     * @return
     */
    private WebElement getSubTopElement(WebElement container, String subTopItem) {
        try {
            List<WebElement> webElements = container
                    .findElements(By.tagName("li"));

            WebElement element = null;

            for (int i = 0; i < webElements.size(); i++) {
                try {
                    System.out.println(webElements.get(i).findElement(By.tagName("a")).getText().toLowerCase() +" "+subTopItem);
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
    /**
     * поиск локатора выпадающей панели
     * @param topItem
     * @return
     */
    private String getCSSLocatorSubMenu(String topItem){
        switch (topItem.toLowerCase()){
            case "тренинги": return ".three_item_menu";
            case "услуги и продукты": return ".one_item_menu";
            case "вакансии": return ".two_item_menu";
            default: return null;
        }
    }
    /**
     * Открывает панель выбранного элемента меню
     * @param topItem
     * @return
     */
    public void openSubMenu(String topItem) {
        $(By.id("nav"))
                .$(By.partialLinkText(topItem)).click();
    }
}
