package tests;

import helpers.Driver;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.fail;

public abstract class TestSignatur {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        new Driver();
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
