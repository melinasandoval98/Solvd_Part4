package webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderStepNavigationBar extends AbstractUIObject {

    public enum CheckoutOrderSteps {
        SUMMARY("Summary"), SIGN_IN("Sign in"), ADDRESS("Address"), SHIPPING("Shipping"), PAYMENT("Payment");
        private String text;

        CheckoutOrderSteps(String text) {
            this.text = text;
        }
    }

    @FindBy(xpath = ".//li//span[contains(text(),'Shipping')]")
    private ExtendedWebElement orderStep;


    public OrderStepNavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getOrderStepButton(CheckoutOrderSteps checkoutOrderStep) {
        return orderStep.format(checkoutOrderStep.text);
    }

}
