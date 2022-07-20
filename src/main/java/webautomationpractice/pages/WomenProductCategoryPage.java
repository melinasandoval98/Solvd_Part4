package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.LeftColumn;

import java.util.List;

public class WomenProductCategoryPage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//span[text()='Women']")
    private ExtendedWebElement womenPageHeading;

    @FindBy(id = "left_column")
    private LeftColumn leftColumn;

    @FindBy(css = "div.product-container")
    private List<ExtendedWebElement> productsContainers;

    public WomenProductCategoryPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php?id_category=3&controller=category");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftColumn getLeftColumn() {
        return leftColumn;
    }

    public List<ExtendedWebElement> getProductsContainers() {
        return productsContainers;
    }

    @Override
    public boolean isPageOpened() {
        return womenPageHeading.isElementPresent();
    }
}
