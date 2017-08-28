package helpers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;

public class Driver {
    static {
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
    }
    public static WebDriver getDriver() {
        return WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.firefox());
    }
}
