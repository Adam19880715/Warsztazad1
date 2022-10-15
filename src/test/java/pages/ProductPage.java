package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static def.BrowserHooks.driver;
import static org.junit.Assert.assertTrue;

public class ProductPage {

    @FindBy(id = "group_1")
    private WebElement productSizeDropdown;
    @FindBy(id = "quantity_wanted")
    private WebElement productsQuantityInput;
    @FindBy(className = "add-to-cart")
    private WebElement addToCartButton;
    @FindBy(id = "myModalLabel")
    private WebElement modalTitle;
    @FindBy(css = "a.btn.btn-primary")
    private WebElement proceedToCheckoutButton;


    public void selectProductSize(String productSize) {
        Select product = new Select(productSizeDropdown);
        product.selectByVisibleText(productSize);
    }

    public void enterProductsQuantity(String productQuantity) {
        productsQuantityInput.click();
        productsQuantityInput.clear();
        productsQuantityInput.sendKeys(productQuantity);
    }

    public void clickAddToCartButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addToCartButton.click();
    }

    public void checkIfModalTitleIsCorrect(String expectedModalTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5_000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalLabel")));

        assertTrue(modalTitle.getText().contains(expectedModalTitle));
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
