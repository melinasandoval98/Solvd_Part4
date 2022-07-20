package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.OrderStepNavigationBar;

public class PaymentPage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(id = "order_step")
    private OrderStepNavigationBar orderStepNavigationBar;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a/span[contains(text(),'Proceed to checkout')]")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(css = "[title='Pay by bank wire']")
    private ExtendedWebElement payWithBankWireButton;

    @FindBy(css = "[title*='Pay by check']")
    private ExtendedWebElement payWithCheckButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?controller=order&multi-shipping=");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public OrderStepNavigationBar getOrderStepNavigationBar() {
        return orderStepNavigationBar;
    }

    public BankWirePaymentPage choosePayWithBankWireOption() {
        payWithBankWireButton.click();
        return new BankWirePaymentPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return payWithBankWireButton.isElementPresent();
    }
}
