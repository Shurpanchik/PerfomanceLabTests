package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static helpers.ReflectionData.getElementLocator;
import static helpers.TestLogger.getLog;

/**
 * Суперкласс для работы со всеми элементами
 *
 * @author a.epishin
 */
public class Element extends ElementsContainer implements AbstractElement {

    /**
     * Клик по произвольному элементу
     */
    @Override
    public void click() {
        try {
           getLog().info("Клик по элементу с локатором: " + getLocator());
            if (getSelf().getAttribute("type") != null && getSelf().getAttribute("type").equals("checkbox")){
                //для чекбоксов отображается свойство displayed:false, из-за которого не дает кликнуть по-нормальному
                flash(getSelf()).getWrappedElement().click();
            }
            else flash(getSelf()).click();
        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
    }
    /*
        Получение текста с элемента
     */
    @Override
    public String getText(){
        try {
            getLog().info("Получение текста с элемента " + getLocator());
           return getSelf().getText();
        } catch (Exception e) {
            getLog().error(e.getMessage());
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
     * Подсветка активного элемента + фокус
     *
     * @param element Объект класса SelenideElement
     * @return Для обеспечения возможность сразу работать с элементом, возвращаем ссылку на него же
     */
    static SelenideElement flash(SelenideElement element) {
        String bgColor = element.getCssValue("backgroundColor");
        changeColor(element, "#00FF00");
        changeColor(element, bgColor);
        return element;
    }

    /**
     * Изменение цвета
     *
     * @param element Объект класса SelenideElement
     * @param color   Цвет элемента в hex-представлении.
     */
    private static void changeColor(SelenideElement element, String color) {
        executeJavaScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        executeJavaScript("arguments[0].focus()", element);
    }

    /**
     * Ожидание появления определенного элемента
     *
     * @param element Объект класса Element
     *
     * @return true/false в зависимости от того, получилось ли дождаться элемент на timeout
     */
    public static boolean elementIsVisible(SelenideElement element){
        return element.waitUntil(Condition.visible, Configuration.timeout).isDisplayed();
    }

    /**
     * Ожидание появления определенного элемента
     *
     * @param element Объект класса Element
     *
     * @return true/false в зависимости от того, получилось ли дождаться элемент на timeout
     */
    public static boolean elementContainsText(SelenideElement element, String text){
        return element.waitUntil(Condition.text(text), Configuration.timeout).isDisplayed();
    }

}
