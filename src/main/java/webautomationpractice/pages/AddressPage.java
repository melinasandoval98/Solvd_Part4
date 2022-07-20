package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.OrderStepNavigationBar;

import static webautomationpractice.components.OrderStepNavigationBar.CheckoutOrderSteps.SIGN_IN;

public class AddressPage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(css = "page-heading")
    private ExtendedWebElement pageHeading;

    @FindBy(id = "order_step")
    private OrderStepNavigationBar orderStepNavigationBar;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/button/span[contains(text(),'Proceed to checkout')]")
    private ExtendedWebElement proceedToCheckoutButton;

    public AddressPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?controller=order&step=1&multi-shipping=0");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public OrderStepNavigationBar getOrderStepNavigationBar() {
        return orderStepNavigationBar;
    }

    public ShippingPage goToNextOrderStepPageOnCheckout() {
        proceedToCheckoutButton.click();
        return new ShippingPage(getDriver());
    }

    public AddressPage clickOnSingInTabButton() {
        getOrderStepNavigationBar().getOrderStepButton(SIGN_IN).click();
        return new AddressPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return pageHeading.isElementPresent() && pageHeading.getText().equalsIgnoreCase("ADDRESSES");
    }
}
