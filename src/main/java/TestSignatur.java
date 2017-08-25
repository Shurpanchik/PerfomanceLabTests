
import helpers.Driver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public abstract class TestSignatur {

    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
      Driver.updateDriver();
    }

    @After
    public void tearDown() throws Exception{
        Driver.getInstance().quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
