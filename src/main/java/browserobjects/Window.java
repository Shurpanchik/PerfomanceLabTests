package browserobjects;

import org.openqa.selenium.WebDriver;

public class Window {

    public static boolean isOpenBlankLink(WebDriver driver, int maxWaitTimeInSeconds,  int periodInSeconds, int indexBlankWindow){
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
