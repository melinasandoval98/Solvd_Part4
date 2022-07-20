package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TermsOfServicePage extends AbstractPage {
    @FindBy(xpath = "//h1[text()='Terms and conditions of use']")
    private ExtendedWebElement pageHeading;

    public TermsOfServicePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?id_cms=3&controller=cms&content_only=1");
    }

    @Override
    public boolean isPageOpened() {
        return pageHeading.isElementPresent();
    }
}
