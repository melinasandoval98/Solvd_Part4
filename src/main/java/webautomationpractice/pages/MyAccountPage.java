package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.components.HeaderMenu;

public class MyAccountPage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;
    @FindBy(xpath = "//h1[text()='My account']")
    private ExtendedWebElement myAccountPageHeading;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?controller=my-account");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    @Override
    public boolean isPageOpened() {
        return myAccountPageHeading.isElementPresent();
    }
}
