package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

/**
 * User: Nahid Chowdhury
 * Date: 7/7/2020
 * Time: 5:59 PM
 */
public class YoutubePageObjects {

    WebDriver driver = null;

    By searchBox = By.name("search_query");
    By searchButton = By.id("search-icon-legacy");
    By kudoPage = By.xpath("//*[@class='style-scope ytd-channel-name']//*[text()='KUDO']");

    public YoutubePageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchBox() {
        driver.findElement(searchBox).click();
    }

    public void enterSearchText(String searchText) {
        driver.findElement(searchBox).sendKeys(searchText);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).sendKeys(Keys.RETURN);
    }

    public void clickKudoLogo() {
        driver.findElement(kudoPage).click();
    }

    /*Casting WebDriver object to TakeScreenshot.
     * Creating screenshot using getScreenshotAs method
     * putting file to specific dir
     * (https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TakesScreenshot.html)*/
    public void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/youtubepage.png"));
    }

}
