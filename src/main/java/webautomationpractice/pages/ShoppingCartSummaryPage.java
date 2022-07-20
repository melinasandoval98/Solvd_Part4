package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.OrderStepNavigationBar;

public class ShoppingCartSummaryPage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(id = "order_step")
    private OrderStepNavigationBar orderStepNavigationBar;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a/span[contains(text(),'Proceed to checkout')]")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(id = "total_price")
    private ExtendedWebElement totalPrice;

    public ShoppingCartSummaryPage(WebDriver driver) {
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

    public AbstractPage goToNextOrderStepPageOnCheckout() {
        proceedToCheckoutButton.click();
        if (headerMenu.isSignInButtonPresent()) {
            return new AuthenticationPage(getDriver());
        } else {
            return new AddressPage(getDriver());
        }
    }

    @Override
    public boolean isPageOpened() {
        return totalPrice.isElementPresent();
    }
}
