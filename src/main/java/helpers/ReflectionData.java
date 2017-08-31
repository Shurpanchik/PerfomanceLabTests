package helpers;

import com.codeborne.selenide.SelenideElement;
import elements.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Получение различных данных при помощи рефлексии
 *
 * @author a.epishin
 */
public class ReflectionData {

    private static final Logger logger = LogManager.getLogger(ReflectionData.class);
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
           logger.error("Не вышло получить локатор элемента");
        }
        return "";
    }


}

