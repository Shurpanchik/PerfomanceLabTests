package tests;

import helpers.Driver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import steps.ArticleInPerfomanceFromSearchSteps;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public abstract class TestSignatur {

    private StringBuffer verificationErrors = new StringBuffer();
    protected ArticleInPerfomanceFromSearchSteps articleInPerfomanceFromSearchSteps = new ArticleInPerfomanceFromSearchSteps();

    @Before
    public void setUp() throws Exception {
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception{
        Driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
