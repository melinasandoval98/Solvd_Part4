package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.OrderStepNavigationBar;

public class ShippingPage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(id = "order_step")
    private OrderStepNavigationBar orderStepNavigationBar;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/button/span[contains(text(),'Proceed to checkout')]")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(css = "[type=checkbox]")
    private ExtendedWebElement agreeToTermsOfServicesCheckbox;

    @FindBy(xpath = "//a[contains(text(),'(Read the Terms of Service)')]")
    private ExtendedWebElement termsOfServicePageLink;

    @FindBy(xpath = "//p[text()='You must agree to the terms of service before continuing.']")
    private ExtendedWebElement youMustAgreeWithTOSPopUp;

    @FindBy(css = ".fancybox-item.fancybox-close")
    private ExtendedWebElement closeYouMustAgreeWithTOSPopUpIcon;

    public ShippingPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?controller=order&step=2&multi-shipping=");
    }


    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public OrderStepNavigationBar getOrderStepNavigationBar() {
        return orderStepNavigationBar;
    }

    public void checkAgreeToTOSCheckBox() {
        agreeToTermsOfServicesCheckbox.check();
    }

    public TermsOfServicePage openTermsOfServicePage() {
        termsOfServicePageLink.check();
        return new TermsOfServicePage(getDriver());
    }


    public PaymentPage goToNextOrderStepPageOnCheckout() {
        proceedToCheckoutButton.click();
        if (!agreeToTermsOfServicesCheckbox.isChecked()) {
            Assert.assertTrue(youMustAgreeWithTOSPopUp.isElementPresent());
            closeYouMustAgreeWithTOSPopUpIcon.click();
            agreeToTermsOfServicesCheckbox.check();
            proceedToCheckoutButton.click();
        }
        return new PaymentPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return termsOfServicePageLink.isElementPresent();
    }
}
