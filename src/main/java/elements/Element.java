package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static helpers.ReflectionData.getElementLocator;

/**
 * Суперкласс для работы со всеми элементами
 */
public class Element extends ElementsContainer {

    private static final Logger logger = LogManager.getLogger(Element.class);

    /**
     * Клик по произвольному элементу
     */
    public void click() {
        try {
           logger.info("Клик по элементу с локатором: " + getLocator());
            if (getSelf().getAttribute("type") != null && getSelf().getAttribute("type").equals("checkbox")){
                //для чекбоксов отображается свойство displayed:false, из-за которого не дает кликнуть по-нормальному
                flash(getSelf()).getWrappedElement().click();
            }
            else flash(getSelf()).click();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    /*
        Получение текста с элемента
     */
    public String getText(){
        try {
            logger.info("Получение текста с элемента " + getLocator());
           return getSelf().getText();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * Пополучение локатора по которому найден элемент
     *
     * @return Локатор элемента, либо пустая строка в случае если вызвано исключение
     */
    String getLocator() {
        return getElementLocator(getSelf());
    }

    /**
     * фокус
     *
     * @param element Объект класса SelenideElement
     * @return Для обеспечения возможность сразу работать с элементом, возвращаем ссылку на него же
     */
    static SelenideElement flash(SelenideElement element) {
        changeFocus(element);
        return element;
    }

    /**
     * Изменение цвета
     *
     * @param element Объект класса SelenideElement
     */
    private static void changeFocus(SelenideElement element) {
        executeJavaScript("arguments[0].focus()", element);
    }

}
