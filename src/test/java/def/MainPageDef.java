package def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

import static def.BrowserHooks.driver;

public class MainPageDef {

    private final MainPage mainPage;

    public MainPageDef() {
        this.mainPage = PageFactory.initElements(driver, MainPage.class);
    }


    @Given("User selects {string}")
    public void selectProductByName(String productName) {
        mainPage.selectProductByProductName(productName);
    }

    @Then("User sees {string} breadcrumbs")
    public void userSeesBreadcrumbs(String expectedBreadCrumbs) {
        mainPage.checkIfBreadCrumbsAreCorrect(expectedBreadCrumbs);
    }

    @And("User goes to main page")
    public void userGoesToMainPage() {
        mainPage.goToMainPage();
    }


}
