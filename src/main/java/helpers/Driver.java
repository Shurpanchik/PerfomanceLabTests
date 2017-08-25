package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public static synchronized WebDriver getInstance() {
        if (driver == null) {
            // Как запустить тесты из firefox под selenium v3
            //http://learn-automation.com/use-firefox-selenium-using-geckodriver-selenium-3/
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");

            updateDriver();
        }
        return driver;
    }

    public static void updateDriver() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
