package Pages.PerfomanceLabSite.Pages;

import Pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SoftwareTestingPage extends Page {

    private By serviceAutoTesting;

    public SoftwareTestingPage(WebDriver driver) {
        super(driver);
        serviceAutoTesting = By.cssSelector(".entry-content > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
    }

    public void goToAvtomatizacijaTestirovanijaPage(){
        driver.findElement(serviceAutoTesting).click();
    }
}
