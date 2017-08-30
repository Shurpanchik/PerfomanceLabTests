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

    default File createTempFile() throws IOException {
        File tempFile = File.createTempFile("autotest_file", ".txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
        out.write("Test file");
        out.close();
        return tempFile;
    }

    default void submit() {
    }

    default void click() {
    }

    default void sendKeys(String text) {
    }

    default void submitKeys(String text) {
    }

    default void checkText(String text) {
    }

    default void clear() {
    }

    default void selectItem(String text) {
    }

    default void selectRow(String text) {
    }

    default void clickButtonFromRow(String text, String button) {
    }

    default void attachDocument(String text) {
    }

    default String getText(){
        return null;
    }
}
