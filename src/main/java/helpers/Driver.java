package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static Driver instance;
    private static WebDriver driver;

    public static synchronized Driver getInstance() {
        if (instance == null) {
            // Как запустить тесты из firefox под selenium v3
            //http://learn-automation.com/use-firefox-selenium-using-geckodriver-selenium-3/
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");

            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            instance = new Driver();
        }
        return instance;
    }
}
