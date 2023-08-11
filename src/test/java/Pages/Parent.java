package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;


public class Parent {

    public Parent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element, String text) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }


    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void jsClickFunction(WebElement element) {
        waitUntilClickable(element);
        js.executeScript("arguments[0].click();", element);
    }

    public void beymenCookies() {

        List<WebElement> acceptAllCookiesButton = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("onetrust-accept-btn-handler"), 0));
        List<WebElement> genderOptionCloseButton = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("button[type='button']>svg"), 0));

        if (acceptAllCookiesButton.size() > 0) {
            clickFunction(acceptAllCookiesButton.get(0));
        }

        if (genderOptionCloseButton.size() > 0) {
            clickFunction(genderOptionCloseButton.get(0));
        }
    }

    public void actions(WebElement element, String str) {
        Actions action = new Actions(GWD.getDriver());
        switch (str.toLowerCase()) {
            case "hover":
                action.moveToElement(element).build().perform();
                break;

        }
    }

    public int randomGenerator(int max) {
        return (int) (Math.random() * max);
    }

    public Select select(WebElement element) {
        waitUntilClickable(element);
        return new Select(element);
    }

    public void waitUntilVisibleAllElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }


    public void verifyContainsTextFunction(WebElement element, String value) {
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()), "No Such Text()");

    }


}