package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends AbstractPage {
    @FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
    private ExtendedWebElement yourOrderIsCompleteBlockHeading;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?controller=order-confirmation&id_cart=4836208&id_module=3&id_order=454343&key=d7265858b9a75066d509e47cb549d1c3");
    }

    @Override
    public boolean isPageOpened() {
        return yourOrderIsCompleteBlockHeading.isElementPresent();
    }
}
