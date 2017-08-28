package pages;

import helpers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;

public abstract class Page extends Driver {


    public  Page (){
    }
    public void openLink(String text){

        getDriver().findElement(By.partialLinkText(text)).click();
    }
}
