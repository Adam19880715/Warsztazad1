package def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import utils.ScreenShots;

import static def.BrowserHooks.driver;

public class CartDef {

    private final CartPage cartPage;

    public CartDef() {
        this.cartPage = PageFactory.initElements(driver, CartPage.class);
    }


    @Then("User is on card page")
    public void userIsOnCardPage() {
        cartPage.checkIfUserIsOnCartPage();
    }

    @And("User selects {string} shipping method")
    public void userSelectsPickUpInStoreShippingMethod(String deliveryMethod) {
        cartPage.checkoutToDeliveryStep();
        cartPage.selectDeliveryOption(deliveryMethod);
    }

    @And("User selects payment method")
    public void userSelectsPaymentMethod() {
        cartPage.checkoutToPaymentStep();
        cartPage.selectPaymentOption();
    }

    @And("User agrees terms of service")
    public void userAgreesTermsOfService() {
        cartPage.approveConditions();
    }

    @And("User goes to next step")
    public void userGoesToNextStep() {
        cartPage.clickOrderObligationButton();
    }

    @Then("User sees {string} title")
    public void userSeesTitle(String orderConfirmationTitle) {
        cartPage.checkIfOrderConfirmationTitleIsCorrect(orderConfirmationTitle);
    }

    @And("User sees {string} information")
    public void userSeesInformation(String emailOrderConfirmation) {
        cartPage.checkIfOrderConfirmationEmailIsCorrect(emailOrderConfirmation);
    }

    @And("User makes screenshot")
    public void userMakesScreenshot() {
        ScreenShots.makeScreenShot();
    }



}
