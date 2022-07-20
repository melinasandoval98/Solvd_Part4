package webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webautomationpractice.components.HeaderMenu;
import webautomationpractice.components.ProductContainer;

import java.util.List;

public class HomePage extends AbstractPage {
    @FindBy(id = "header")
    private HeaderMenu headerMenu;

    @FindBy(css = "ul#homefeatured *.product-container")
    private List<ProductContainer> productsContainersUnderPopularTab;

    @FindBy(css = "ul#blockbestsellers *.product-container")
    private List<ProductContainer> productsContainersUnderBestSellersTab;

    @FindBy(css = ".homefeatured")
    private ExtendedWebElement popularTabButton;
    @FindBy(css = ".blockbestsellers")
    private ExtendedWebElement bestSellersTabButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("index.php");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }


    public void clickPopularTabButton() {
        popularTabButton.click();
    }

    public void clickBestsellerTabButton() {
        bestSellersTabButton.click();
    }

    public List<ProductContainer> getProductsContainersUnderPopularTab() {
        return productsContainersUnderPopularTab;
    }

    public List<ProductContainer> getProductsContainersUnderBestSellersTab() {
        return productsContainersUnderBestSellersTab;
    }

    @Override
    public boolean isPageOpened() {
        return popularTabButton.isElementPresent();
    }
}
