package elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Интерфейс, содержащий все кастомные методы элементов
 * Нужен для возможность вызовов когда не известен класс конечного элемента
 * <p>
 * Например: pageObject.getElement(nameOfElement).sendKeys(text);
 *
 * @author a.epishin
 */
public interface AbstractElement {

    default void click() {
    }

    default void submitKeys(String text) {
    }
    default String getText(){
        return null;
    }
}
