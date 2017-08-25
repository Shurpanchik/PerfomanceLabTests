package steps;

import org.openqa.selenium.WebDriver;
import pages.perfomancelabsite.top.SubTopServices;

public class OpenSubTopStep {
    public OpenSubTopStep(WebDriver driver){
        SubTopServices subTopServices = new SubTopServices();
        subTopServices.openSubTop();
    }
}
