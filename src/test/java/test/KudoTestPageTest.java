package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.KudoTestPageObjects;

import java.io.IOException;
import java.util.Arrays;

/**
 * User: Nahid Chowdhury
 * Date: 7/7/2020
 * Time: 8:18 PM
 */
public class KudoTestPageTest {

    String projectPath = System.getProperty("user.dir");
    private static WebDriver driver = null;
    String testUrl = "https://live.kudoway.com/test";

    @BeforeSuite
    public void setUp() {
        ChromeOptions optionsC = new ChromeOptions();
        optionsC.addArguments(Arrays.asList("disable-infobars",
                "ignore-certificate-errors",
                "start-maximized",
                "use-fake-ui-for-media-stream"));
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    //Due to security measure selenium does not allow the browser mic and fails to load the Screenshot button.
    @Test
    public void kudoTest() throws InterruptedException, IOException {
        driver.get(testUrl);
        KudoTestPageObjects kudoTestPageObjects = new KudoTestPageObjects(driver);
        kudoTestPageObjects.clickStartButton();
        Thread.sleep(3000);
        //kudoTestPageObjects.clickScreenshotButton();
        kudoTestPageObjects.takeScreenshot("test.png");
        System.out.println("Screenshot clicked");
        Thread.sleep(3000);
    }


    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
