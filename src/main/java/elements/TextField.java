package elements;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;


/**
 * Класс для работы с элементами TextField
 *
 * @author a.epishin
 */
public class TextField extends Element {

    /**
     * Заполнение текстового поля + подтверждение ввода
     *
     * @param text текст для заполнения
     */
    private static final Logger logger = LogManager.getLogger(TextField.class);

    public void submitKeys(String text) {
        try {
            logger.info("Заполнение поля " + getLocator() + " данными: " + text);
            flash(getSelf()).setValue(text).submit();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
