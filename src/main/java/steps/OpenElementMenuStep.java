package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenElementMenuStep {
    public OpenElementMenuStep(WebDriver driver, By element){
        driver.findElement(element).click();
    }
}
