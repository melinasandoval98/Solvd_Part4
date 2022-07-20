package webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.pages.ShoppingCartSummaryPage;

public class ProductAddedToCartPopUp extends AbstractUIObject {
    @FindBy(xpath = ".//span[@title='Continue shopping']/span")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = ".//span[contains(text(),'Proceed to checkout')]")
    private ExtendedWebElement proceedToCheckoutButton;

    public ProductAddedToCartPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public ShoppingCartSummaryPage clickOnProceedToCheckOutButton() {
        proceedToCheckoutButton.click();
        return new ShoppingCartSummaryPage(getDriver());
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    @Override
    public boolean isUIObjectPresent(long timeout) {
        return continueShoppingButton.isElementPresent() && proceedToCheckoutButton.isElementPresent();
    }
}
