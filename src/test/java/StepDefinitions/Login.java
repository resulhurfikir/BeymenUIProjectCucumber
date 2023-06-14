package StepDefinitions;

import Pages.Elements;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.en.*;
import java.util.ArrayList;
import static org.testng.Assert.*;

public class Login {

    Elements e = new Elements();

    @Given("Navigate to Beymen website")
    public void navigateToBeymenWebSite() {
        GWD.getDriver().get("https://www.beymen.com/");
    }

    @And("Close the cookies")
    public void closeTheCookiesIfThereAre() {
        e.beymenCookies();
    }

    @And("Click on the *hesabim* link")
    public void clickOnTheHesabimLink() {
        e.clickFunction(e.hesabimLink);
    }

    @When("Login the WebSite")
    public void loginTheWebSite() {
    }

    @Then("Verify that the user should be logged successfully")
    public void verifyThatTheUserShouldBeLoggedSuccessfully() {
        e.waitUntilClickable(e.logOutButton);
        assertTrue(e.logOutButton.isDisplayed());
    }

    @When("User enter email as {string}  password  as {string}")
    public void userEnterEmailAsPasswordAs(String email, String password) {
        e.waitUntilClickable(e.loginButton);
        e.sendKeysFunction(e.emailBox, email);
        e.sendKeysFunction(e.passwordBox, password);
        e.clickFunction(e.loginButton);
    }

    @When("User enter valid email and password")
    public void userEnterValidEmailAndPassword() {
        ArrayList<ArrayList<String>> loginInfo =
                ExcelUtility.getDataExcel("src/test/java/Utilities/resource/LoginInfo.xlsx","Login",2);
        e.waitUntilClickable(e.loginButton);
        e.sendKeysFunction(e.emailBox, loginInfo.get(0).get(0));
        e.sendKeysFunction(e.passwordBox, loginInfo.get(0).get(1));
        e.clickFunction(e.loginButton);
    }

    @Then("Verify that the user should not be logged successfully")
    public void verifyThatTheUserShouldNotBeLoggedSuccessfully() {
        e.waitUntilVisible(e.girisYapilamadiErrorBox);
       assertTrue(e.girisYapilamadiErrorBox.isDisplayed());
    }
}
