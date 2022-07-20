package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.OrderStepNavigationBar;

public class AuthenticationPage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(id = "order_step")
    private OrderStepNavigationBar orderStepNavigationBar;

    @FindBy(css = "input#email")
    private ExtendedWebElement emailInputField;

    @FindBy(css = "input#passwd")
    private ExtendedWebElement passwordInputField;

    @FindBy(css = "button#SubmitLogin")
    private ExtendedWebElement singInButton;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a/span[contains(text(),'Proceed to checkout')]")
    private ExtendedWebElement proceedToCheckoutButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public OrderStepNavigationBar getOrderStepNavigationBar() {
        return orderStepNavigationBar;
    }

    public AddressPage goToNextOrderStepPageOnCheckout() {
        proceedToCheckoutButton.click();
        return new AddressPage(getDriver());
    }

    public AddressPage singInAccount(String email, String password) {
        emailInputField.type(email);
        passwordInputField.type(password);
        singInButton.click();
        return new AddressPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return singInButton.isElementPresent();
    }
}
