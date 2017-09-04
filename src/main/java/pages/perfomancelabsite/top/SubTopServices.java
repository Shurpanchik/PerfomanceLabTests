package pages.perfomancelabsite.top;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.Element;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public SelenideElement getMenuTopItem(String topItem, String subTopItem){
        try {
            SelenideElement top = $(getCSSLocatorSubMenu(topItem));

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
    private SelenideElement getSubTopElement(SelenideElement container, String subTopItem) {
        try {
            ElementsCollection selenideElements = container.$$(By.tagName("li"));

            SelenideElement element;

            for (SelenideElement selenideElement : selenideElements) {
                 element = selenideElement.$(By.tagName("a"));
                 if(element!=null &&
                         element.getText().toLowerCase().equals(subTopItem.toLowerCase())) {
                     return element;
                 }
            }
            return null;
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
    private By getCSSLocatorSubMenu(String topItem){
        switch (topItem.toLowerCase()){
            case "тренинги": return By.cssSelector(".three_item_menu");
            case "услуги и продукты": return By.cssSelector(".one_item_menu");
            case "вакансии": return By.cssSelector(".two_item_menu");
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
