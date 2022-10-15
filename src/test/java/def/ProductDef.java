package def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.ProductPage;

import static def.BrowserHooks.driver;

public class ProductDef {

    private final ProductPage productPage;

    public ProductDef() {
        this.productPage = PageFactory.initElements(driver, ProductPage.class);
    }


    @And("User selects size {string}")
    public void userSelectsSize(String productSize) {
        productPage.selectProductSize(productSize);
    }

    @And("User selects quantity {string}")
    public void userSelectsQuantity(String productsQuantity) {
        productPage.enterProductsQuantity(productsQuantity);
    }

    @And("User clicks add to cart button")
    public void userClicksAddToCartButton() {
        productPage.clickAddToCartButton();
    }

    @Then("Modal with {string} success information is visible")
    public void modalWithSuccessInformationIsVisible(String expectedModalTitle) {
        productPage.checkIfModalTitleIsCorrect(expectedModalTitle);
    }

    @When("User proceed to checkout")
    public void userProceedToCheckout() {
        productPage.clickProceedToCheckoutButton();
    }
}
