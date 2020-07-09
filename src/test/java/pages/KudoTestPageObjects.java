package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * User: Nahid Chowdhury
 * Date: 7/7/2020
 * Time: 8:15 PM
 */
public class KudoTestPageObjects {

    WebDriver driver = null;

    By startButton = By.xpath("//*[@id=\"precall\"]/div[2]/button");
    By screenshotButton = By.id("screenshot");

    public KudoTestPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStartButton() {
        driver.findElement(startButton).click();
    }

    /*public void clickScreenshotButton() {
        getScreenshotButton().click();
    }

    public WebElement getScreenshotButton(){r
        WebElement element= driver.findElement(screenshotButton);
        return element;
    }*/

    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./screenshots/" + fileName));
    }
}
