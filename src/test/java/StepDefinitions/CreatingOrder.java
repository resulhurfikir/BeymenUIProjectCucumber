package StepDefinitions;

import Pages.Elements;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import static org.testng.Assert.*;

public class CreatingOrder {

    Elements e = new Elements();
    String chosenProductName;
    @And("Hover to element")
    public void hoverToElement(DataTable dt) {
        List<String> hover = dt.asList(String.class);
        for (String h:hover){
            WebElement webElement =e.getWebElement(h);
            e.waitUntilVisible(webElement);
            new Actions(GWD.getDriver()).moveToElement(webElement).build().perform();
        }
    }

    @And("Click on the Element")
    public void clickOnTheElement(DataTable dt) {
        List<String> buttons = dt.asList(String.class);
        for (String b:buttons){
            WebElement webElement = e.getWebElement(b);
            e.clickFunction(webElement);
        }
    }

    @And("Add the product to the basket randomly from result list")
    public void addTheProductToTheBasketRandomlyFromResultList() {
        e.clickFunction(e.productList.get(e.randomGenerator(e.productList.size())));
        chosenProductName =e.chosenProduct.getText();
        e.clickFunction(e.addToBasket);
    }

    @Then("Verify that the chosen product is in the basket")
    public void verifyThatTheChosenProductIsInTheBasket() {
        boolean flag=false;
        e.waitUntilClickable(e.satinAlButton);
        for (WebElement w: e.productsInTheBasket){
            if (w.getText().equals(chosenProductName)){
                flag=true;
            }
        }
        assertTrue(flag);
    }

    @And("jsClick on the Element")
    public void jsclickOnTheElement(DataTable dt) {
        List<String> buttons = dt.asList(String.class);
        for (String b:buttons){
            WebElement w = e.getWebElement(b);
            e.jsClickFunction(w);
        }
    }

    @And("SendKeys to the Element")
    public void sendkeysToTheElement(DataTable dt) {
        List<List<String>> items = dt.asLists(String.class);
        for (int i = 0; i < items.size(); i++) {
            WebElement w = e.getWebElement(items.get(i).get(0));
            e.sendKeysFunction(w,items.get(i).get(1));
        }
    }

    @And("Choose the filtering options")
    public void chooseTheFilteringOptions(DataTable dt) {
        List<String> buttons = dt.asList(String.class);
        for (String b:buttons){
            WebElement w = e.getWebElement(b);
            e.waitUntilVisible(w);
            e.clickFunction(w);
        }
    }

    @And("Add the product to the favorites randomly from result list")
    public void addTheProductToTheFavoritesRandomlyFromResultList() {
        e.waitUntilVisibleAllElements(e.productList);
        int random = e.randomGenerator(e.productList.size());
        chosenProductName=e.productList.get(random).getText();
        e.actions(e.addFavoriteBasketButton.get(random),"hover");
        e.clickFunction(e.addFavoriteBasketButton.get(random));
        e.clickFunction(e.addFavoriteButton);
    }

    @And("Add the product to the basket from favorites")
    public void addTheProductToTheBasketFromFavorites() {
        e.jsClickFunction(e.navigateToFavorites);
        for (WebElement w:e.productInTheFavorites){
            if (w.getText().equals(chosenProductName))
                e.clickFunction(e.addToBasketInFavorite);
            e.jsClickFunction(e.navigateToBasket);
        }
    }
}
