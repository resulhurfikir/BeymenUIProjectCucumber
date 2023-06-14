package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Elements extends Parent {

    public Elements() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[title='Hesabım']")
    public WebElement hesabimLink;
    @FindBy(id = "customerEmail")
    public WebElement emailBox;
    @FindBy(id = "password")
    public WebElement passwordBox;
    @FindBy(id = "loginBtn")
    public WebElement loginButton;
    @FindBy(id = "exitBtnTop")
    public WebElement logOutButton;
    @FindBy(id = "notifyerror")
    public WebElement girisYapilamadiErrorBox;
    @FindBy(id = "addressBtn")
    public WebElement addressButton;
    @FindBy(id = "country")
    public WebElement countrySelect;
    @FindBy(id = "district")
    public WebElement districtSelect;
    @FindBy(id = "neighborhood")
    public WebElement neighborhoodSelect;
    @FindBy(id = "addressDescription")
    public WebElement addressDescription;
    @FindBy(id = "addressName")
    public WebElement addressName;
    @FindBy(id = "saveAddressBtn")
    public WebElement addressSaveButton;
    @FindBy(id = "notifyMessage")
    public WebElement addressSuccessMessage;
    @FindBy(id = "newAddressBtn")
    public List<WebElement> newAddressButton;
    @FindBy(id = "newAddressBtn2")
    public WebElement newAddressButton2;
    @FindBy(linkText = "Kadın")
    public WebElement kadinLink;
    @FindBy(css = "[title='Aksesuar']")
    public WebElement aksesuarLink;
    @FindBy(linkText = "Kol saati")
    public WebElement kolSaatiLink;
    @FindBy(css = "h3[class='m-productCard__desc']")
    public List<WebElement> productList;
    @FindBy(css = "[class='o-productDetail__description']")
    public WebElement chosenProduct;
    @FindBy(id = "addBasket")
    public WebElement addToBasket;
    @FindBy(css = "[title='Sepetim']")
    public WebElement navigateToBasket;
    @FindBy(css = "[class='m-basket__productInfoName']")
    public List<WebElement> productsInTheBasket;
    @FindBy(id = "nextBtn")
    public WebElement satinAlButton;
    @FindBy(css = "div[role='combobox']>input")
    public WebElement searchBox;
    @FindBy(css = "[type='button']")
    public WebElement searchButton;
    @FindBy(id = "productFilterOpenButton")
    public WebElement filterOpen;
    @FindBy(xpath = "//span[text()='Ürün Grubu']")
    public WebElement urunGrubu;
    @FindBy(css = "[for='4536']")
    public WebElement giyimDisi;
    @FindBy(xpath = "//span[text()='Marka']")
    public WebElement marka;
    @FindBy(css = "[for='55620']")
    public WebElement apple;
    @FindBy(xpath = "//span[text()='Ürün Çeşidi']")
    public WebElement urunCesidi;
    @FindBy(css = "[for='42644']")
    public WebElement tablet;
    @FindBy(xpath = "//span[text()='Renk']")
    public WebElement renk;
    @FindBy(css = "[for='2471']")
    public WebElement gri;
    @FindBy(id = "productFilterApplyButton")
    public WebElement applyFilter;
    @FindBy(xpath = "//button[contains(text(),'FAVORİ')]")
    public List<WebElement> addFavoriteBasketButton;
    @FindBy(id = "addFavorite")
    public WebElement addFavoriteButton;
    @FindBy(css = "[class*='darkButton']")
    public WebElement addToBasketInFavorite;
    @FindBy(css = "span[class='m-productCard__desc']")
    public List<WebElement> productInTheFavorites;
    @FindBy(css = "[title='Favorilerim']")
    public WebElement navigateToFavorites;
    @FindBy(id = "paymentBtn")
    public WebElement devamEtButton;
    @FindBy(id = "cardNo")
    public WebElement cardNo;
    @FindBy(id = "cardHolderName")
    public WebElement cardHolderName;
    @FindBy(id = "cardMonth")
    public WebElement cardMonth;
    @FindBy(id = "cardYear")
    public WebElement cardYear;
    @FindBy(id = "cardCvv")
    public WebElement cardCvv;
    @FindBy(xpath = "(//*[@class='m-checkbox'])[3]")
    public WebElement checkBox;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "kadinLink": return kadinLink;
            case "aksesuarLink": return aksesuarLink;
            case "kolSaatiLink": return kolSaatiLink;
            case "navigateToBasket": return navigateToBasket;
            case "searchBox": return searchBox;
            case "searchButton": return searchButton;
            case "filterOpen": return filterOpen;
            case "urunGrubu": return urunGrubu;
            case "giyimDisi": return giyimDisi;
            case "marka": return marka;
            case "apple": return apple;
            case "urunCesidi": return urunCesidi;
            case "tablet": return tablet;
            case "renk": return renk;
            case "gri": return gri;
            case "applyFilter": return applyFilter;
            case "satinAlButton": return satinAlButton;
            case "devamEtButton": return devamEtButton;
            case "cardNo": return cardNo;
            case "cardHolderName": return cardHolderName;
            case "cardMonth": return cardMonth;
            case "cardYear": return cardYear;
            case "cardCvv": return cardCvv;
            case "checkBox": return checkBox;

        }
        return null;
    }


}
