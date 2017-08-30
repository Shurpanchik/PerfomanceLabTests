package helpers;

import com.codeborne.selenide.SelenideElement;
import org.reflections.Reflections;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import static helpers.TestLogger.getLog;


/**
 * Получение различных данных при помощи рефлексии
 *
 * @author a.epishin
 */
public class ReflectionData {

    private ReflectionData() {
        throw new IllegalAccessError("Utility class");
    }


    private static Reflections reflections = new Reflections("ru.psb");


    /**
     * Получает локатор по которому был найден элемент
     *
     * @param element объект класса SelenideElement
     * @return объект класса AbstractPage
     */
    public static String getElementLocator(SelenideElement element) {
        try {
            InvocationHandler innerProxy = Proxy.getInvocationHandler(element);
            Field field = innerProxy.getClass().getDeclaredField("webElementSource");
            field.setAccessible(true);
            return field.get(innerProxy).toString();
        } catch (NoSuchFieldException | IllegalAccessException e) {
           getLog().error("Не вышло получить локатор элемента");
        }
        return "";
    }


}

