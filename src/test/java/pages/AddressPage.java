package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static def.BrowserHooks.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressPage {

    @FindBy(css = "#content span")
    private List<WebElement> contentBoxes;
    @FindBy(xpath = "//input[@name='alias']")
    private WebElement aliasInput;
    @FindBy(xpath = "//input[@name='address1']")
    private WebElement addressInput;
    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postalCodeInput;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;
    @FindBy(xpath = "//select[@name='id_country']")
    private WebElement countryDropdown;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneInput;
    @FindBy(css = ".alert-success")
    private WebElement alertSuccess;
    @FindBy(css = ".address-body h4")
    private WebElement addressAlias;
    @FindBy(css = "address")
    private WebElement address;
    @FindBy(xpath = "//a[@data-link-action='delete-address']")
    private WebElement removeAddressLink;


    public void openAddressForm() {
        contentBoxes.get(1).click();
    }

    public void enterAlias(String alias) {
        aliasInput.sendKeys(alias);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterCountry(String country) {
        Select countries = new Select(countryDropdown);
        countries.selectByVisibleText(country);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneInput.sendKeys(phoneNumber);
    }

    public void clickSaveButton() {
        driver.findElements(By.xpath("//button[@type='submit']")).get(1).click();
    }

    public void checkIfSuccessAlertIsCorrect(String expectedAlert) {
        String alertFromPage = alertSuccess.getText();
        assertEquals(alertFromPage, expectedAlert);
    }

    public void checkIfAliasIsCorrect(String expectedAlias) {
        String aliasFromPage = addressAlias.getText();
        assertEquals(aliasFromPage, expectedAlias);
    }

    public void checkIfAddressIsCorrect(String expectedAddress) {
        String addressFromPage = address.getText();
        assertTrue(addressFromPage.contains(expectedAddress));
    }

    public void checkIfPostalCodeIsCorrect(String expectedPostalCode) {
        String postalCodeFromPage = address.getText();
        assertTrue(postalCodeFromPage.contains(expectedPostalCode));
    }

    public void checkIfCityIsCorrect(String expectedCity) {
        String cityFromPage = address.getText();
        assertTrue(cityFromPage.contains(expectedCity));
    }

    public void checkIfCountryIsCorrect(String expectedCountry) {
        String countryFromPage = address.getText();
        assertTrue(countryFromPage.contains(expectedCountry));
    }

    public void checkIfPhoneNumberIsCorrect(String expectedPhoneNumber) {
        String phoneNumberFromPage = address.getText();
        assertTrue(phoneNumberFromPage.contains(expectedPhoneNumber));
    }

    public void removeAddress() {
        removeAddressLink.click();
    }

    public void checkIfBoxWithAddressDataIsNotExist() {
        List<WebElement> address = driver.findElements(By.cssSelector("address"));
        assertEquals(0, address.size());
    }
}
