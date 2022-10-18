package def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class BrowserHooks {

    public static WebDriver driver;
    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Before
    public void openBrowser() {
        driver.get(PropertiesReader.url());
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
