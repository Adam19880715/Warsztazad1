package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CartPage {

    @FindBy(css = ".cart-preview.active")
    private WebElement blockCart;
    @FindBy(id = "checkout-delivery-step")
    private WebElement checkoutDeliveryStep;
    @FindBy(className = "delivery-option")
    private List<WebElement> deliveryOptions;
    @FindBy(id = "checkout-payment-step")
    private WebElement checkoutPaymentStep;
    @FindBy(xpath = "//label[@for='payment-option-1']")
    private WebElement paymentOption;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement conditionsToApprove;
    @FindBy(css = "button.btn.btn-primary.center-block")
    private WebElement orderWithObligationButton;
    @FindBy(css = "#content-hook_order_confirmation h3")
    private WebElement orderConfirmation;
    @FindBy(css = "#content-hook_order_confirmation p")
    private WebElement emailConfirmation;


    public void checkIfUserIsOnCartPage() {
        assertTrue(blockCart.isDisplayed());
    }

    public void checkoutToDeliveryStep() {
        checkoutDeliveryStep.click();
    }

    public void selectDeliveryOption(String deliveryMethod) {
        deliveryOptions
                .stream()
                .filter(webElement -> webElement.getText().contains(deliveryMethod))
                .findFirst()
                .get()
                .click();
    }

    public void checkoutToPaymentStep() {
        checkoutPaymentStep.click();
    }

    public void selectPaymentOption() {
        paymentOption.click();
    }

    public void approveConditions() {
        conditionsToApprove.click();
    }

    public void clickOrderObligationButton() {
        orderWithObligationButton.click();
    }

    public void checkIfOrderConfirmationTitleIsCorrect(String orderConfirmationTitle) {
        assertTrue(orderConfirmation.getText().contains(orderConfirmationTitle));
    }

    public void checkIfOrderConfirmationEmailIsCorrect(String emailOrderConfirmation) {
        assertTrue(emailConfirmation.getText().contains(emailOrderConfirmation));
    }
}
