package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    @FindBy(xpath = "//input[@name='email']")
    private List<WebElement> emailInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(css = "#submit-login")
    private WebElement submitButton;
    @FindBy(className = "account")
    private WebElement account;


    public void enterUsername() {
        emailInput.get(0).sendKeys(PropertiesReader.login());
    }

    public void enterPassword() {
        passwordInput.sendKeys(PropertiesReader.password());
    }

    public void clickLoginButton() {
        submitButton.click();
    }

    public void checkIfUserIsLogged() {
        assertTrue(account.getText().contains(PropertiesReader.firstName()));
        assertTrue(account.getText().contains(PropertiesReader.lastName()));
    }
}
