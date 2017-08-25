package pages;

import helpers.Driver;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    private WebDriver driver;

    public  Page (){
        this.driver = Driver.getInstance();
    }
    public WebDriver getDriver() {
        return driver;
    }

}
