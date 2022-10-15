package def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.AddressPage;

import static def.BrowserHooks.driver;

public class AddressDef {

    private final AddressPage addressPage;

    public AddressDef() {
        this.addressPage = PageFactory.initElements(driver, AddressPage.class);
    }


    @Given("User opens address form")
    public void openAddressForm() {
        addressPage.openAddressForm();
    }

    @And("User enters address data {string} {string} {string} {string} {string} {string}")
    public void userEntersAddressData(String alias, String address, String postalCode, String city, String country, String phoneNumber) {
        addressPage.enterAlias(alias);
        addressPage.enterAddress(address);
        addressPage.enterPostalCode(postalCode);
        addressPage.enterCity(city);
        addressPage.enterCountry(country);
        addressPage.enterPhoneNumber(phoneNumber);
    }

    @And("User clicks save button")
    public void userClicksSaveButton() {
        addressPage.clickSaveButton();
    }

    @And("User sees {string} as success confirmation alert")
    public void userSeesAsSuccessConfirmationAlert(String expectedAlert) {
        addressPage.checkIfSuccessAlertIsCorrect(expectedAlert);
    }

    @Then("Data are correct {string} {string} {string} {string} {string} {string}")
    public void dataAreCorrect(String expectedAlias, String expectedAddress, String expectedPostalCode, String expectedCity, String expectedCountry, String expectedPhoneNumber) {
        addressPage.checkIfAliasIsCorrect(expectedAlias);
        addressPage.checkIfAddressIsCorrect(expectedAddress);
        addressPage.checkIfPostalCodeIsCorrect(expectedPostalCode);
        addressPage.checkIfCityIsCorrect(expectedCity);
        addressPage.checkIfCountryIsCorrect(expectedCountry);
        addressPage.checkIfPhoneNumberIsCorrect(expectedPhoneNumber);
    }

    @When("User removes address")
    public void userRemovesAddress() {
        addressPage.removeAddress();
    }

    @Then("Box with address is not exist")
    public void boxWithAddressIsNotExist() {
        addressPage.checkIfBoxWithAddressDataIsNotExist();
    }

    @And("User enters address data {string} {string} {string} {string} {string}")
    public void userEntersAddressData(String address, String postalCode, String city, String country, String phoneNumber) {
        addressPage.enterAddress(address);
        addressPage.enterPostalCode(postalCode);
        addressPage.enterCity(city);
        addressPage.enterCountry(country);
        addressPage.enterPhoneNumber(phoneNumber);
    }
}
