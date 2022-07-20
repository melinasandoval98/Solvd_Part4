package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BankWirePaymentPage extends AbstractPage {
    @FindBy(xpath = "//h3[contains(text(),'Bank-wire payment')]")
    private ExtendedWebElement blockHeading;

    @FindBy(xpath = "//span[text()='I confirm my order']")
    private ExtendedWebElement confirmMyOrderButton;

    public BankWirePaymentPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?fc=module&module=bankwire&controller=payment");
    }

    public OrderConfirmationPage clickOnConfirmOrderButton() {
        confirmMyOrderButton.click();
        return new OrderConfirmationPage(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return blockHeading.isElementPresent();
    }
}
