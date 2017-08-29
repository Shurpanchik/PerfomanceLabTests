package helpers;

import Listener.EventListener;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;

public class Driver {
    static {
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
    }
    public static WebDriver getDriver() {
        WebDriver driver1 = new EventFiringWebDriver(WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.firefox()));
        ((EventFiringWebDriver) driver1).register(new EventListener());
        return driver1;
        //return WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.firefox());
    }
}
