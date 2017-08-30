package helpers;

import Listener.EventListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.codeborne.selenide.WebDriverRunner;



import java.util.concurrent.TimeUnit;

public class Driver {
    static {
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
        Configuration.timeout = 30000;
        // оказывается firefox версии выше 48 -это Marionette
        Configuration.browser = "Marionette";
        WebDriverRunner.addListener(new EventListener());
    }
    public static WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }
    public static void close(){
        WebDriverRunner.closeWebDriver();
    }
}
