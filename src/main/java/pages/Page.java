package pages;

import helpers.Driver;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver driver;

    public  Page (){
        this.driver = Driver.getInstance();
    }
    public WebDriver getDriver() {
        return driver;
    }

}
