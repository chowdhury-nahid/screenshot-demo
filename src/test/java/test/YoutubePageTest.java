package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.YoutubePageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * User: Nahid Chowdhury
 * Date: 7/7/2020
 * Time: 5:49 PM
 */
public class YoutubePageTest {

    String projectPath = System.getProperty("user.dir");
    private static WebDriver driver = null;
    @BeforeSuite
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    String testUrl = "https://www.youtube.com/";

    @Test
    public void verifyStartButton() throws InterruptedException, IOException {
        YoutubePageObjects youtubePageObjects = new YoutubePageObjects(driver);
        driver.get(testUrl);
        Thread.sleep(3000);
        youtubePageObjects.clickSearchBox();
        youtubePageObjects.enterSearchText("kudoway");
        Thread.sleep(2000);
        youtubePageObjects.clickSearchButton();
        Thread.sleep(3000);
        youtubePageObjects.clickKudoLogo();
        Thread.sleep(3000);
        youtubePageObjects.takeScreenshot();
        Thread.sleep(3000);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
