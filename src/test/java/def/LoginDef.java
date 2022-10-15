package def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;

import static def.BrowserHooks.driver;

public class LoginDef {

    private final MainPage mainPage;
    private final LoginPage loginPage;

    public LoginDef() {
        this.mainPage = PageFactory.initElements(driver, MainPage.class);
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
    }


    @Given("User opened correct url")
    public void userOpenedCorrectUrl() {
        mainPage.checkIfUrlIsCorrect();
    }

    @And("User is logged")
    public void userLogInToApp() {
        mainPage.openLogInForm();

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();

        loginPage.checkIfUserIsLogged();
    }
}
