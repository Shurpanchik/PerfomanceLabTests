package pages.perfomancelabsite.pages;

import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SoftwareTestingPage extends Page {

    private By serviceAutoTesting;

    public SoftwareTestingPage() {
        super();
        serviceAutoTesting = By.cssSelector(".entry-content > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
    }

    public By getServiceAutoTesting() {
        return serviceAutoTesting;
    }
}
