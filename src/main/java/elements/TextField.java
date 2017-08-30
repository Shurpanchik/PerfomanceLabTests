package elements;


import org.openqa.selenium.WebElement;

import static helpers.TestLogger.getLog;

/**
 * Класс для работы с элементами TextField
 *
 * @author a.epishin
 */
public class TextField extends Element {

    /**
     * Заполнение текстового поля
     *
     * @param text текст для заполнения
     */
    @Override
    public void sendKeys(String text) {
        try {
            getLog().info("Заполнение поля " + getLocator() + " данными: " + text);
            getSelf().setValue(text);
        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
    }

    /**
     * Заполнение текстового поля + подтверждение ввода
     *
     * @param text текст для заполнения
     */
    @Override
    public void submitKeys(String text) {
        try {
            getLog().info("Заполнение с подтверждением поля " + getLocator() + " данными: " + text);
            getSelf().setValue(text).submit();
        } catch (Exception e) {
            getLog().error(e.getMessage());
        }
    }
}
