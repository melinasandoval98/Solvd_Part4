package webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.pages.HomePage;
import webautomationpractice.pages.ShoppingCartSummaryPage;
import webautomationpractice.pages.SignInPage;
import webautomationpractice.pages.WomenProductCategoryPage;

import java.util.List;

import static webautomationpractice.components.HeaderMenu.ProductCategories.WOMEN;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(css = ".login")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = ".//a[@title='View my shopping cart']")
    private ExtendedWebElement shoppingCartButton;

    @FindBy(xpath = ".//div[@class='shopping_cart']//..//a//span[contains(@class,'no_product')]")
    private ExtendedWebElement emptyCartStatus;

    @FindBy(id = "header_logo")
    private ExtendedWebElement linkToHomePageHeaderLogo;

    @FindBy(xpath = ".//div[@id='block_top_menu']/ul/li/a[contains(text(),'%s')]")
    private ExtendedWebElement productCategoryButton;

    @FindBy(css = ".cart-info")
    private List<ProductAddedToCart> productsInCartDropdown;

    public enum ProductCategories {
        WOMEN("Women"), DRESSES("Dresses"), T_SHIRTS("T-shirts");

        String categoryName;

        ProductCategories(String category) {
            this.categoryName = category;
        }
    }


    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public WomenProductCategoryPage openWomenCategoryPage() {
        productCategoryButton.format(WOMEN.categoryName).click();
        return new WomenProductCategoryPage(getDriver());
    }


    public ShoppingCartSummaryPage clickShoppingCartButton() {
        shoppingCartButton.click();
        return new ShoppingCartSummaryPage(getDriver());
    }

    public void displayProductsInCartDropdown() {
        shoppingCartButton.hover();
    }

    public HomePage openHomePage() {
        linkToHomePageHeaderLogo.click();
        return new HomePage(getDriver());
    }

    public SignInPage openSignInPage() {
        signInButton.click();
        return new SignInPage(getDriver());
    }

    public boolean isSignInButtonPresent() {
        return signInButton.isElementPresent();
    }

    public List<ProductAddedToCart> getProductsInCartDropdown() {
        return productsInCartDropdown;
    }

    public boolean isCartEmpty() {
        return emptyCartStatus.isElementPresent();
    }

    @Override
    public boolean isUIObjectPresent() {
        return linkToHomePageHeaderLogo.isElementPresent();
    }
}
