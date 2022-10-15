package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static def.BrowserHooks.driver;

public class ScreenShots {

    public static void makeScreenShot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(PropertiesReader.screenShotsPath() + TimeStamp.timestamp() + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
