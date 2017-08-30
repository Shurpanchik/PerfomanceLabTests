package pages.perfomancelabsite.pages;

import elements.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SoftwareTestingPage extends Page {

    @FindBy(css = ".entry-content > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")
    private Element serviceAutoTesting;

    public SoftwareTestingPage() {
        super();
    }

    public Element getServiceAutoTesting() {

        return serviceAutoTesting;
    }
}
