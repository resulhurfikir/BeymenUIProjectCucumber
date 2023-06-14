package StepDefinitions;

import Pages.Elements;
import Utilities.DBUtility;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class Address {

    Elements e = new Elements();
    Faker faker = new Faker();

    @When("User click on the *adreslerim* button")
    public void userClickOnTheAdreslerimButton() {
        e.clickFunction(e.addressButton);
    }

    @And("Choose the city")
    public void chooseTheCity() {
        e.select(e.countrySelect).selectByVisibleText("Trabzon");
    }

    @And("Choose the district")
    public void chooseTheDistrict() {
        e.select(e.districtSelect).selectByVisibleText("Vakfıkebir");
    }

    @And("Choose the neighbourhood")
    public void chooseTheNeighbourhood() {
        e.select(e.neighborhoodSelect).selectByValue("30852");
    }

    @And("Enter the address from *FakerClass*")
    public void enterTheAddressFromFakerClass() {
        e.sendKeysFunction(e.addressDescription, faker.address().fullAddress());
    }


    @And("Enter the address name from database with {string}")
    public void enterTheAddressNameFromDatabaseWith(String query) {
        ArrayList<ArrayList<String>> dbList = DBUtility.getListData(query);
        e.sendKeysFunction(e.addressName, dbList.get(0).get(1).trim());
    }

    @And("Click on the *kaydet* button")
    public void clickOnTheKaydetButton() {
        e.clickFunction(e.addressSaveButton);
    }

    @Then("Verify that the process is successful")
    public void verifyThatAddingANewAddressIsSuccess() {
        e.verifyContainsTextFunction(e.addressSuccessMessage, "başarı");
    }

    @And("Click on the *YeniAdresEkle* button")
    public void clickOnTheYeniAdresEkleButton() {
        if (e.newAddressButton.size() > 0)
            e.clickFunction(e.newAddressButton.get(0));
        else
            e.clickFunction(e.newAddressButton2);
    }


}
