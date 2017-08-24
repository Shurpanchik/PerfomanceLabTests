import Pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class SearchPerfomanceLabTest {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // Как запустить тесты из firefox под selenium v3
        //http://learn-automation.com/use-firefox-selenium-using-geckodriver-selenium-3/
        System.setProperty("webdriver.gecko.driver","src\\main\\java\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void SearchYandex() throws InterruptedException {
        driver.get("https://yandex.ru/");
        By searchPanel = By.cssSelector("#text");
        writeArticle("yandex", searchPanel);
    }

    @Test
    public void SearchRambler() throws InterruptedException {
        driver.get("https://rambler.ru/");
        By searchPanel = By.cssSelector("#search_query");
        writeArticle("rambler", searchPanel);
    }
    @Test
    public void SearchGoogle() throws InterruptedException {
        driver.get("https://google.ru/");
        By searchPanel = By.cssSelector("#lst-ib");
        writeArticle("google", searchPanel);
    }
    private void writeArticle(String fileName, By searchPanel){
        SearchPage searchPage = new SearchPage(driver, searchPanel);

        // отправляем поисковый запрос перфоманс лаб
        searchPage.sendSearch("perfomance lab");

        //находим ссылку сайта
       // searchPage.openLink("performance-lab.ru");
        driver.findElement(By.partialLinkText("Перфоманс Лаб - Услуги по тестированию")).click();

        // так как сайт компании открывается в соседней вкладке, то переключимся на нее
        if(!isOpenBlankLink(5,1, 1)){
            fail("В новом окне вкладка с сайтом perfomance lab не появилась");
        }

        // подводим курсор к меню Продукты и услуги
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-item-317\"]/a"))).build().perform();

        // в меню переходим в раздел тестирование
        driver.findElement(By.cssSelector(".one_item_menu > div:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();

        // переходим в меню Автоматизация тестирования
        driver.findElement(
                By.cssSelector(".entry-content > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")
        ).click();

        // получаем весь текст из статьи
        writeArticle(fileName,driver.findElement(By.className("content-area")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private void writeArticle( String fileName, String text){
        try {
            FileWriter writer = new FileWriter(fileName, false);
            try {
                writer.write(text);
                writer.flush();
            } finally {
                writer.close();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private boolean isOpenBlankLink(int maxWaitTimeInSeconds, int periodInSeconds, int indexBlankWindow){
        int currentTime=0;
        while (currentTime <= maxWaitTimeInSeconds){
            try {
                Thread.sleep(periodInSeconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                String window = driver.getWindowHandles().toArray()[indexBlankWindow].toString();
                driver.switchTo().window(window);
                currentTime += periodInSeconds;
                return true;
            }
            catch (Exception exx){
                currentTime += periodInSeconds;
            }
        }
        return false;
    }
}
