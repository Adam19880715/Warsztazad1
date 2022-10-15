package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;

import java.util.List;

import static def.BrowserHooks.driver;
import static org.junit.Assert.assertEquals;

public class MainPage {

    @FindBy(css = "#_desktop_user_info a")
    private WebElement logInLink;
    @FindBy(className = "product-title")
    private List<WebElement> productList;
    @FindBy(css = "ol")
    private WebElement breadCrumbs;
    @FindBy(className = "logo")
    private WebElement logo;


    public void checkIfUrlIsCorrect() {
        assertEquals(PropertiesReader.url(), driver.getCurrentUrl());
    }

    public void openLogInForm() {
        logInLink.click();
    }

    public void goToMainPage() {
        logo.click();
    }

    public void selectProductByProductName(String productName) {
        productList
                .stream()
                .filter(element -> element.getText().toLowerCase().equals(productName.toLowerCase()))
                .findFirst()
                .get()
                .click();
    }

    public void checkIfBreadCrumbsAreCorrect(String expectedBreadCrumbs) {
        assertEquals(breadCrumbs.getText(), expectedBreadCrumbs);
    }
}
